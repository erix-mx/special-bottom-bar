package mx.erix.specialbottombar.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var state by mutableStateOf(MainState())
    private set

    fun dispatchEvent(event: MainEvent) {
        when(event) {
            is MainEvent.OnThemeChanged -> {
                state = state.copy(
                    currentTheme = event.name
                )
            }

            is MainEvent.OnPageSelected -> {
                state = state.copy(
                    currentPageSelected = event.id
                )
            }
        }
    }
}