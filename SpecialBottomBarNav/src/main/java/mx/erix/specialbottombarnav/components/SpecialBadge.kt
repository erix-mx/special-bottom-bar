package mx.erix.specialbottombarnav.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.erix.specialbottombarnav.data.SpecialBottom

@Composable
fun SpecialBadge(
    modifier: Modifier = Modifier,
    config: SpecialBottom.Badge,
) {

    config.text?.let {
        Box(
            modifier = modifier
                .border(1.5.dp, config.textColor, CircleShape)
                .padding(1.dp),

            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(19.dp)
                    .clip(CircleShape)
                    .background(config.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = config.text,
                    color = config.textColor,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 11.sp
                )
            }
        }
    } ?: Box(
        modifier = modifier
            .border(1.5.dp, config.textColor, CircleShape)
            .padding(1.dp),

        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(config.backgroundColor),
        )
    }

}

@Preview
@Composable
fun SpecialBadgePreview() {
    SpecialBadge(
        config = SpecialBottom.Badge(
            text = "1",
            textColor = Color.White,
            backgroundColor = Color.Red
        )
    )
}

@Preview()
@Composable
fun SpecialBadgeSimplePreview() {
    SpecialBadge(
        config = SpecialBottom.Badge(
            textColor = Color.White,
            backgroundColor = Color.Red
        )
    )
}