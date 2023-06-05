package mx.erix.specialbottombar.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.erix.specialbottombar.ui.theme.SpecialBottomBarTheme
import mx.erix.specialbottombar.ui.theme.ThemeColor
import mx.erix.specialbottombar.ui.theme.themeList

@Composable
fun TopAppBarColors(
    title: String = "",
    themes: List<ThemeColor> = themeList,
    onThemeChanged: (ThemeColor) -> Unit = {}
) {

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            color = MaterialTheme.colorScheme.onBackground,
            text = title,
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.titleMedium
        )


        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            themes.forEach { theme ->
                val isSelected = theme.name == title
                Box(
                    modifier = Modifier.run {
                        clip(CircleShape)
                                        .clickable {
                                            onThemeChanged(theme)
                                        }
                                        .width(32.dp)
                                        .height(32.dp)
                                        .background(
                                            brush = androidx.compose.ui.graphics.Brush.linearGradient(
                                                colors = listOf(
                                                    theme.theme.primary,
                                                    theme.theme.secondary
                                                ),
                                                start = Offset(0f, 0f),
                                                end = Offset.Infinite,
                                                tileMode = TileMode.Clamp,
                                            )
                                        )
                                        .border(
                                            width = if (isSelected) 3.dp else 0.1.dp,
                                            color = if (isSelected) MaterialTheme.colorScheme.onBackground else Color.Transparent,
                                            shape = CircleShape
                                        )
                    }

                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun TopAppBarColorsDarkPreview() {
    SpecialBottomBarTheme(
        nameTheme = "dark-zero",
    ) {
        TopAppBarColors(
            title = "Sample 1"
        )
    }
}

@Preview
@Composable
fun TopAppBarColorsLightPreview() {
    SpecialBottomBarTheme(
        nameTheme = "light-theme-1",
    ) {
        TopAppBarColors(
            title = "Sample 2"
        )
    }
}