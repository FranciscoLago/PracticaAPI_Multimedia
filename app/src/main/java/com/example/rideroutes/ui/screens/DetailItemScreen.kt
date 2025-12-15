package com.example.rideroutes.ui.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Pantalla que muestra el detalle de un elemento específico.
 * Adapta su diseño para mejorar la legibilidad en pantallas grandes.
 * @param itemId El ID del elemento a mostrar, recibido desde la navegación.
 */
@Composable
fun DetailItemScreen(itemId: String?) {
    // BoxWithConstraints nos permite adaptar la UI en función del espacio disponible.
    BoxWithConstraints(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        if (maxWidth < 600.dp) {
            // En pantallas compactas, el contenido ocupa todo el ancho.
            CompactDetailItem(itemId)
        } else {
            // En pantallas expandidas, limitamos el ancho para que el texto sea más legible.
            ExpandedDetailItem(itemId)
        }
    }
}

/**
 * Versión compacta de la pantalla de detalle.
 */
@Composable
fun CompactDetailItem(itemId: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DetailContent(itemId)
    }
}

/**
 * Versión expandida de la pantalla de detalle.
 */
@Composable
fun ExpandedDetailItem(itemId: String?) {
    Column(
        modifier = Modifier
            .padding(32.dp)
            .widthIn(max = 700.dp) // Limita el ancho del contenido.
    ) {
        DetailContent(itemId)
    }
}

/**
 * Componente que renderiza el contenido principal de la pantalla de detalle.
 */
@Composable
fun DetailContent(itemId: String?) {
    Text(text = "Elemento ${itemId ?: "N/A"}", style = MaterialTheme.typography.headlineLarge)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Aquí va una descripción mucho más larga y detallada del elemento, explicando todos sus secretos y características.", style = MaterialTheme.typography.bodyLarge)
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Dato adicional 1: Valor 1")
    Text(text = "Dato adicional 2: Valor 2")
    Text(text = "Dato adicional 3: Valor 3")
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = { /* TODO: Añadir a favoritos */ }) {
        Icon(Icons.Default.Favorite, contentDescription = "Añadir a favoritos")
        Text(text = "Añadir a favoritos")
    }
}
