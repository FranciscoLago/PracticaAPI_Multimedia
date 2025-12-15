package com.example.rideroutes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rideroutes.ui.screens.AboutScreen
import com.example.rideroutes.ui.screens.DetailFavScreen
import com.example.rideroutes.ui.screens.DetailItemScreen
import com.example.rideroutes.ui.screens.ElemListScreen
import com.example.rideroutes.ui.screens.FavListScreen
import com.example.rideroutes.ui.screens.ProfileScreen
import com.example.rideroutes.ui.theme.RideRoutesTheme

/**
 * sealed class para definir las rutas y propiedades de las pantallas principales
 * que aparecerán en la barra de navegación inferior.
 */
sealed class Screen(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Home : Screen("elemList", "Home", { Icon(Icons.Default.Home, contentDescription = "Home") })
    object Favorites : Screen("favList", "Favoritos", { Icon(Icons.Default.Favorite, contentDescription = "Favoritos") })
    object Profile : Screen("profile", "Perfil", { Icon(Icons.Default.Person, contentDescription = "Perfil") })
    object About : Screen("about", "About", { Icon(Icons.Default.Info, contentDescription = "About") })
}

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RideRoutesTheme {
                val navController = rememberNavController()
                val items = listOf(Screen.Home, Screen.Favorites, Screen.Profile, Screen.About)

                // Scaffold proporciona la estructura básica de la app (barra superior, inferior, etc.)
                Scaffold(
                    bottomBar = {
                        // NavigationBar es el menú de navegación inferior.
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            items.forEach { screen ->
                                NavigationBarItem(
                                    icon = { screen.icon() },
                                    label = { Text(screen.label) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            // PopUpTo para evitar acumular pantallas en la pila de navegación
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    // NavHost es el contenedor donde se muestran las diferentes pantallas de la app.
                    NavHost(navController = navController, startDestination = Screen.Home.route, modifier = androidx.compose.ui.Modifier.padding(paddingValues)) {
                        composable(Screen.Home.route) { ElemListScreen(navController) }
                        composable("detailItem/{itemId}") { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getString("itemId")
                            DetailItemScreen(itemId = itemId)
                        }
                        composable(Screen.Favorites.route) { FavListScreen(navController) }
                        composable("detailFav/{favId}") { backStackEntry ->
                            val favId = backStackEntry.arguments?.getString("favId")
                            DetailFavScreen(favId = favId)
                        }
                        composable(Screen.Profile.route) { ProfileScreen() }
                        composable(Screen.About.route) { AboutScreen() }
                    }
                }
            }
        }
    }
}
