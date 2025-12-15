package com.example.rideroutes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Pantalla de Perfil de Usuario.
 * Muestra información básica del usuario y un botón para iniciar/cerrar sesión.
 */
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Perfil de Usuario", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Aquí se mostraría la información del usuario (nombre, email, etc.)
        Text(text = "Nombre: Francisco Lago", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Email: franciscolagocervera@gmail.com", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para gestionar la sesión del usuario
        Button(onClick = { /* TODO: Implementar lógica de Login/Logout */ }) {
            Text(text = "Login / Logout")
        }
    }
}
