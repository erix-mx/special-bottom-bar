package mx.erix.specialbottombar.screens

import mx.erix.specialbottombarnav.data.SpecialBottom

sealed class MainEvent {
    class OnThemeChanged(val name: String = "dark-zero"): MainEvent()
    class OnPageSelected(val id: SpecialBottom.Id = SpecialBottom.Id("explore")): MainEvent()
}