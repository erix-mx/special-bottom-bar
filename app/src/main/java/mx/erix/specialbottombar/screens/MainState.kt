package mx.erix.specialbottombar.screens

import mx.erix.specialbottombarnav.data.SpecialBottom

data class MainState(
    val currentTheme: String = "Theme 1",
    val currentPageSelected: SpecialBottom.Id = SpecialBottom.Id("explore")
)