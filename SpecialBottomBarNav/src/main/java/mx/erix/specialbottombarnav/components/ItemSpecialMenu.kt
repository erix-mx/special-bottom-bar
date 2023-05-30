package mx.erix.specialbottombarnav.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import mx.erix.specialbottombarnav.R
import mx.erix.specialbottombarnav.data.SpecialBottom

@Composable
fun ItemSpecialMenu(
    startAnimation: Boolean = true,
    config: SpecialBottom.Item,
    isSelected: Boolean = false,
    color: Color = Color.Black,
    click: () -> Unit = {}
) {

    val iconSelected = if (isSelected) config.activatedIcon else config.icon
    val iconSize = remember {
        Animatable(if (startAnimation) 0f else 29.dp.value)
    }

    LaunchedEffect(key1 = iconSelected) {
        iconSize.animateTo(
            targetValue = 29.dp.value,
            animationSpec = tween(durationMillis = 1_000)
        )
    }

    Column(
        modifier = Modifier
            .width(64.dp)
            .fillMaxHeight()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { click() }
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        ConstraintLayout {
            val (icon, badge) = createRefs()

            val topGuideline = createGuidelineFromTop(7.dp)
            val verticalGuideline = createGuidelineFromStart(0.5f)

            Icon(
                tint = color,
                modifier = Modifier
                    .constrainAs(icon) {
                        top.linkTo(topGuideline)
                        start.linkTo(verticalGuideline)
                        end.linkTo(verticalGuideline)
                    }
                    .width(iconSize.value.dp),
                imageVector = ImageVector.vectorResource(id = iconSelected),
                contentDescription = config.text
            )

            config.badge?.let {
                SpecialBadge(
                    config = it,
                    modifier = Modifier
                        .constrainAs(badge) {
                            top.linkTo(topGuideline)
                            bottom.linkTo(topGuideline)
                            start.linkTo(verticalGuideline)
                            end.linkTo(parent.end)
                        },
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            color = color,
            fontSize = 12.sp,
            text = config.text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.size(2.dp))
    }
}

@Preview(
    heightDp = 72
)
@Composable
fun ItemMenuPreview() {
    ItemSpecialMenu(
        config = SpecialBottom.Item(
            icon = R.drawable.ic_outline_home,
            activatedIcon = R.drawable.ic_fill_home,
            text = "Home",
            id = SpecialBottom.Id("home1"),
            badge = SpecialBottom.Badge(
                text = "1",
                backgroundColor = Color.Black,
                textColor = Color.White
            )
        ),
        isSelected = true,
        startAnimation = false
    )
}

@Preview(
    heightDp = 72
)
@Composable
fun ItemMenuSimpleBadgePreview() {
    ItemSpecialMenu(
        config = SpecialBottom.Item(
            icon = R.drawable.ic_outline_home,
            activatedIcon = R.drawable.ic_fill_home,
            text = "Home",
            id = SpecialBottom.Id("home1"),
            badge = SpecialBottom.Badge(
                backgroundColor = Color.Black,
                textColor = Color.White
            )
        ),
        isSelected = true,
        startAnimation = false
    )
}