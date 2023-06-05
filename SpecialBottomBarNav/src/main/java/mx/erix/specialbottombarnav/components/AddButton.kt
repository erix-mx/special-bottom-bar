package mx.erix.specialbottombarnav.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.erix.specialbottombarnav.R
import mx.erix.specialbottombarnav.data.SpecialBottom

@Composable
fun PlusButton(
    theme: SpecialBottom.Theme = SpecialBottom.Theme(),
    click: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(96.dp)
            .clip(CircleShape)
            .background(theme.backgroundColor)
            .padding(6.dp),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(theme.selectedColor.copy(alpha = 0.2f))
                .padding(7.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(
                        brush = androidx.compose.ui.graphics.Brush.linearGradient(
                            colors = listOf(
                                theme.selectedColor,
                                theme.backGroundSecondaryColor
                            ),
                            start = Offset(0f, 0f),
                            end = Offset.Infinite,
                            tileMode = TileMode.Clamp,
                        )
                    )
                    .clickable { click() },
                contentAlignment = Alignment.Center
            ) {
                theme.iconPlus?.let {
                    Icon(
                        tint = theme.backgroundColor,
                        modifier = Modifier.width(32.dp),
                        imageVector = ImageVector.vectorResource(id = it),
                        contentDescription = null
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun AddButtonPreview() {
    PlusButton(
        theme = SpecialBottom.Theme(
            backgroundColor = Color.Red,
            selectedColor = Color.Yellow,
            iconPlus = R.drawable.ic_outline_radio
        )
    )
}