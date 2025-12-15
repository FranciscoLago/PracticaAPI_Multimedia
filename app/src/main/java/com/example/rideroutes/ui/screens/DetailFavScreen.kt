package com.example.rideroutes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Pantalla que muestra el detalle de un elemento favorito.
 * Incluye una lista de comentarios y un botón FAB para añadir nuevos.
 * @param favId El ID del favorito a mostrar, recibido desde la navegación.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailFavScreen(favId: String?) {
    Scaffold(
        // El FloatingActionButton se define aquí para que se muestre sobre el contenido.
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Lógica para añadir un nuevo comentario */ }) {
                Icon(Icons.Default.Add, contentDescription = "Añadir comentario")
            }
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Detalle del Favorito ${favId ?: "N/A"}", style = MaterialTheme.typography.headlineLarge)

            // Lista de comentarios asociados al elemento
            LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                items(5) { index ->
                    CommentCard(commentIndex = index)
                }
            }
        }
    }
}

/**
 * Componente que muestra un único comentario.
 * @param commentIndex El índice del comentario.
 */
@Composable
fun CommentCard(commentIndex: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "Usuario ${commentIndex + 1}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Este es el contenido del comentario número ${commentIndex + 1}. Es un comentario muy interesante.")
        }
    }
}
