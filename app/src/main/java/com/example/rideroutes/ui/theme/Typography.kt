package com.example.rideroutes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ------------------------------------------------------------------
// INSTRUCCIONES PARA PERSONALIZAR LA TIPOGRAFÍA DE LA APP
// ------------------------------------------------------------------
// 1. Busca fuentes en "Google Fonts" (https://fonts.google.com/).
//    Criterios de búsqueda recomendados:
//    - Para títulos: fuentes "Display" o "Sans Serif" con peso "Bold" o "Medium". Busca legibilidad y personalidad.
//    - Para cuerpo: fuentes "Sans Serif" con peso "Regular". Busca claridad y comodidad de lectura.
// 2. Descarga los archivos .ttf de la fuente elegida.
// 3. Crea una carpeta "font" en "res" (app/src/main/res/font).
// 4. Copia los archivos .ttf en esa nueva carpeta.
// 5. Define tu FontFamily aquí, como en el ejemplo comentado.
// ------------------------------------------------------------------

/*
// Ejemplo de cómo añadir una fuente personalizada llamada "montserrat"
val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)
*/

// Set of Material typography styles to start with
// Por defecto, usa la fuente predeterminada del sistema.
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Personaliza otros estilos de texto si lo necesitas
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold, // Usamos negrita para los títulos
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)
