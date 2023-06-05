package mx.erix.specialbottombarnav.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.erix.specialbottombarnav.data.SpecialBottom
import mx.erix.specialbottombarnav.ext.customShadow

@Composable
fun SpecialBottomBarPlus(

    modifier: Modifier = Modifier,
    menuItems: List<SpecialBottom.Item> = listOf(),
    currentSelected: SpecialBottom.Id,
    onItemSelected: (SpecialBottom.Id) -> Unit = {},
    clickAdd: () -> Unit = {},
    theme: SpecialBottom.Theme = SpecialBottom.Theme(),
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter

    ) {

        Row {
            Box(modifier = Modifier
                .size(100.dp)
                .customShadow(
                    color = theme.shadowColor.copy(alpha = 0.1f),
                    borderRadius = theme.borderRadius,
                    blurRadius = theme.blurRadius,
                    offsetY = 0.dp,
                    offsetX = 0.dp,
                    spread = theme.spread

                )
                .clip(CircleShape)
            )
        }

        Box(
            modifier = Modifier
                .customShadow(
                    color = theme.shadowColor.copy(alpha = 0.2f),
                    borderRadius = theme.borderRadius,
                    blurRadius = theme.blurRadius,
                    offsetY = 0.dp,
                    offsetX = 0.dp,
                    spread = theme.spread
                )
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(theme.backgroundColor)
                .fillMaxWidth()
                .height(76.dp),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {

                menuItems
                    .filterIndexed { index, _ ->
                        index % 2 == 0
                    }
                    .forEach { item ->
                        ItemSpecialMenu(
                            startAnimation = theme.startAnimation,
                            color = if (item.id == currentSelected) theme.selectedColor else theme.unselectedColor,
                            item = item,
                            isSelected = item.id == currentSelected,
                            click = { onItemSelected(item.id) }
                        )
                    }
                Spacer(modifier = Modifier.size(8.dp))
                Box(modifier = Modifier.size(76.dp))
                Spacer(modifier = Modifier.size(8.dp))
                menuItems
                    .filterIndexed { index, _ ->
                        index % 2 != 0
                    }
                    .forEach { item ->
                        ItemSpecialMenu(
                            startAnimation = theme.startAnimation,
                            color = if (item.id == currentSelected) theme.selectedColor else theme.unselectedColor,
                            item = item,
                            isSelected = item.id == currentSelected,
                            click = { onItemSelected(item.id) }
                        )
                    }
            }

        }

        Row {
            PlusButton(
                theme = theme,
                click = clickAdd
            )
        }


    }
}

@Preview(
    heightDp = 200,
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun SpecialBottomBarAddPreview() {
    SpecialBottomBarPlus(
        currentSelected = SpecialBottom.Id("home1")
    )
}
