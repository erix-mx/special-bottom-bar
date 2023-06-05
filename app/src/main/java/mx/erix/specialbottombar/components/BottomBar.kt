package mx.erix.specialbottombar.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import mx.erix.specialbottombar.R

import mx.erix.specialbottombarnav.components.SpecialBottomBar
import mx.erix.specialbottombarnav.data.SpecialBottom

@Composable
fun BottomBar(
    currentSelected: SpecialBottom.Id = SpecialBottom.Id("explore"),
    onItemSelected: (SpecialBottom.Id) -> Unit
) {

    val bottomBarTheme = SpecialBottom.Theme(
        //Shadow
        shadowColor = MaterialTheme.colorScheme.onBackground,
        backgroundColor = MaterialTheme.colorScheme.background,

        //Item
        selectedColor = MaterialTheme.colorScheme.primary,
        unselectedColor = MaterialTheme.colorScheme.onBackground,
    )

    SpecialBottomBar(
        theme = bottomBarTheme,
        menuItems = listOf(
            SpecialBottom.Item(
                icon = R.drawable.ic_outline_home,
                activatedIcon = R.drawable.ic_fill_home,
                tag = "Home",
                id = SpecialBottom.Id("home"),
            ),
            SpecialBottom.Item(
                icon = R.drawable.ic_outline_game,
                activatedIcon = R.drawable.ic_fill_game,
                tag = "Games",
                id = SpecialBottom.Id("games"),
            ),
            SpecialBottom.Item(
                icon = R.drawable.ic_outline_message,
                activatedIcon = R.drawable.ic_fill_message,
                tag = "Messages",
                id = SpecialBottom.Id("post"),
                badge = SpecialBottom.Badge(
                    text = "1",
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    textColor = MaterialTheme.colorScheme.background
                )
            ),
            SpecialBottom.Item(
                icon = R.drawable.ic_outline_notify,
                activatedIcon = R.drawable.ic_fill_nority,
                tag = "Notifications",
                id = SpecialBottom.Id("notifications"),
                badge = SpecialBottom.Badge(
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    textColor = MaterialTheme.colorScheme.background
                )
            )
        ),
        currentSelected = currentSelected,
        onItemSelected = onItemSelected,

    )
}

@Preview
@Composable
fun BottomAppBarDefaultsPreview() {
    BottomBar(
        currentSelected = SpecialBottom.Id("explore"),
        onItemSelected = {}
    )
}