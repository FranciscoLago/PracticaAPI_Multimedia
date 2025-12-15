package com.example.rideroutes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Pantalla principal que muestra la lista de elementos.
 * Adapta su diseño en función del tamaño de la pantalla.
 * @param navController El controlador de navegación para moverse a otras pantallas.
 */
@Composable
fun ElemListScreen(navController: NavController) {
    // BoxWithConstraints nos permite conocer el ancho y alto disponible y adaptar la UI.
    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            // Para pantallas pequeñas (móviles), mostramos una lista vertical.
            CompactElemList(navController = navController)
        } else {
            // Para pantallas más grandes (tablets), mostramos una cuadrícula.
            ExpandedElemList(navController = navController)
        }
    }
}

/**
 * Versión compacta de la lista de elementos (una columna).
 */
@Composable
fun CompactElemList(navController: NavController) {
    LazyColumn {
        items(10) { index ->
            ElementCard(itemIndex = index, onClick = {
                navController.navigate("detailItem/$index")
            })
        }
    }
}

/**
 * Versión expandida de la lista de elementos (cuadrícula de dos columnas).
 */
@Composable
fun ExpandedElemList(navController: NavController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(10) { index ->
            ElementCard(itemIndex = index, onClick = {
                navController.navigate("detailItem/$index")
            })
        }
    }
}

/**
 * Componente personalizado para la tarjeta de un elemento.
 * Muestra información básica y es clicable para navegar al detalle.
 * @param itemIndex El índice del elemento.
 * @param onClick La acción a realizar cuando se pulsa la tarjeta.
 */
@Composable
fun ElementCard(itemIndex: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick) // Hacemos la tarjeta clicable
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Elemento $itemIndex", style = MaterialTheme.typography.titleLarge)
            Text(text = "Descripción corta del elemento $itemIndex")
            IconButton(onClick = { /* TODO: Añadir a favoritos */ }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Añadir a favoritos")
            }
        }
    }
}
