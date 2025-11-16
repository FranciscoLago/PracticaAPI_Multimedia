package com.example.rideroutes.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.rideroutes.R

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent {
            AboutScreen()
        }
    }

    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("franciscolagocervera@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Información sobre RideRoutes")
            putExtra(Intent.EXTRA_TEXT, "Hola,\n\nQuisiera recibir información sobre RideRoutes 🏍️.\n\nUn saludo.")
        }

        startActivity(Intent.createChooser(emailIntent, "Enviar correo con…"))
    }



    @Composable
    fun AboutScreen() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.about_title), style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = stringResource(R.string.about_theme), style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.about_description),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Versión: 1.0", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(24.dp))

                // Botón de envío de correo
                Button(onClick = { sendEmail() }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Correo")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Contactar")

                }
            }
        }
    }
}
