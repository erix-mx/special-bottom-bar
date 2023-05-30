package mx.erix.specialbottombarnav.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class SpecialBottom {

    data class Badge(
        val backgroundColor: Color = Color.White,
        val textColor: Color = Color.Black,
        val text: String? = null
    ) : SpecialBottom()

    data class Id(val key: String) : SpecialBottom()
    data class Item(
        @DrawableRes val icon: Int,
        @DrawableRes val activatedIcon: Int,
        val text: String,
        val id: SpecialBottom.Id,
        val badge: SpecialBottom.Badge? = null
    ) : SpecialBottom()

    data class Theme(
        val backgroundColor: Color = Color.White,
        val selectedColor: Color = Color.Black,
        val unselectedColor: Color = Color.Gray,
        val spread: Dp = 8.dp,
        val blurRadius: Dp = 16.dp,
        val borderRadius: Dp = 32.dp,
        val startAnimation: Boolean = true,
        @DrawableRes val iconAdd: Int? = null,
    ) : SpecialBottom()

}