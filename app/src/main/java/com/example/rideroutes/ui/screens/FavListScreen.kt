package com.example.rideroutes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
 * Pantalla que muestra la lista de elementos marcados como favoritos.
 * @param navController El controlador de navegación para ir a otras pantallas.
 */
@Composable
fun FavListScreen(navController: NavController) {
    LazyColumn {
        items(3) { index -> // Datos de ejemplo, solo 3 favoritos
            FavoriteElementCard(itemIndex = index, onClick = {
                // Navega a la pantalla de detalle del favorito pasando su ID
                navController.navigate("detailFav/$index")
            })
        }
    }
}

/**
 * Componente personalizado para la tarjeta de un elemento favorito.
 * Muestra información básica, un botón para eliminar y es clicable.
 * @param itemIndex El índice del elemento.
 * @param onClick La acción a realizar cuando se pulsa la tarjeta.
 */
@Composable
fun FavoriteElementCard(itemIndex: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Favorito ${itemIndex + 1}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Descripción corta del elemento favorito ${itemIndex + 1}")
            // Botón para eliminar el elemento de la lista de favoritos
            IconButton(onClick = { /* TODO: Implementar lógica para eliminar de favoritos */ }) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar de favoritos")
            }
        }
    }
}
