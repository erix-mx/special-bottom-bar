package mx.erix.specialbottombar.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import mx.erix.specialbottombar.components.TopAppBarColors
import mx.erix.specialbottombar.ui.theme.SpecialBottomBarTheme
import mx.erix.specialbottombarnav.data.SpecialBottom
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.erix.specialbottombar.components.BottomBar
import mx.erix.specialbottombar.components.BottomBarPlus
import mx.erix.specialbottombar.components.DemoCard
import mx.erix.specialbottombar.demo_data.pets
import mx.erix.specialbottombarnav.components.SpecialBottomBar

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    MainScreenContent(
        state = viewModel.state,
        onEvent = viewModel::dispatchEvent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(
    state: MainState = MainState(),
    onEvent: (MainEvent) -> Unit = {}
) {
    SpecialBottomBarTheme(
        nameTheme = state.currentTheme
    ) {

        Scaffold(
            contentColor = MaterialTheme.colorScheme.background,
            topBar = {
                TopAppBarColors(
                    title = state.currentTheme,
                    onThemeChanged = {onEvent(MainEvent.OnThemeChanged(it.name))}
                )
            },
            bottomBar = {
                BottomBarPlus(
                    currentSelected = state.currentPageSelected,
                    onItemSelected = {
                        onEvent(MainEvent.OnPageSelected(it))
                    }
                )
            },
        ) { paddingValues ->


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = 0.dp
                    ),

                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(top = 32.dp, bottom = 100.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    pets.forEach {
                        item {
                            DemoCard(it)
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}