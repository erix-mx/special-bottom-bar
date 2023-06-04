package mx.erix.specialbottombar.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

data class ThemeColor(
    val name: String = "dark-zero",
    val isDark: Boolean = true,
    val theme: ColorScheme = darkColorScheme(
        primary = Color(0xFF6200EE),
        secondary = Color(0xFF5238E9),
        surface = Color(0xFF272938),
        background = Color(0xFF191920),
        onBackground = Color(0xFFDEDEDE),
    )
)

val themeList = listOf(

    ThemeColor(),

    ThemeColor(
        name = "light-theme-1",
        isDark = false,
        theme = lightColorScheme(
            primary = Color(0xFFCF5CAB),
            secondary = Color(0xFF4F3280),
            surface = Color(0xFFFFFFFF),
            background = Color(0xFFE4E5EE),
            onBackground = Color(0xFF383838),
        )
    ),

    ThemeColor(
        name = "dark-theme-1",
        isDark = true,
        theme = darkColorScheme(
            primary = Color(0xFFA752A5),
            secondary = Color(0xFFCA4981),
            surface = Color(0xFF1F1F1F),
            background = Color(0xFF161616),
            onBackground = Color(0xFFFFFFFF),
        )
    ),

    ThemeColor(
        name = "dark-theme-2",
        isDark = true,
        theme = darkColorScheme(
            primary = Color(0xFFE15D29),
            secondary = Color(0xFFD23F2B),
            surface = Color(0xFF222741),
            background = Color(0xFF1A1E2F),
            onBackground = Color(0xFFB7BAD7),
        )
    ),

    ThemeColor(
        name = "light-theme-2",
        isDark = false,
        theme = lightColorScheme(
            primary = Color(0xFFE59398),
            secondary = Color(0xFFF0AFB9),
            surface = Color(0xFFFBFAFE),
            background = Color(0xFFDBDDE1),
            onBackground = Color(0xFF374157),
        )
    ),
)