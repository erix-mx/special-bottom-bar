package mx.erix.specialbottombar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.erix.specialbottombar.ui.theme.SpecialBottomBarTheme
import mx.erix.specialbottombarnav.data.SpecialBottom


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpecialBottomBarTheme {

                SpecialBottomBarTheme {
                    // A surface container using the 'background' color from the theme
                    var itemSelected by remember { mutableStateOf(SpecialBottom.Id("home1")) }
                    Scaffold(
                        bottomBar = {
                            /*SpecialBottomBarAdd(
                                menuItems = listOf(
                                    SpecialBottom.Item(
                                        icon = R.drawable.ic_outline_home,
                                        activatedIcon = R.drawable.ic_fill_home,
                                        text = "Home1",
                                        id = SpecialBottom.Id("home1"),
                                    ),
                                    SpecialBottom.Item(
                                        icon = R.drawable.ic_outline_home,
                                        activatedIcon = R.drawable.ic_fill_home,
                                        text = "Home2",
                                        id = SpecialBottom.Id("home2"),
                                        badge = SpecialBottom.Badge(
                                            text = "1",
                                            backgroundColor = Color.Black,
                                            textColor = Color.White
                                        )
                                    ),
                                    SpecialBottom.Item(
                                        icon = R.drawable.ic_outline_home,
                                        activatedIcon = R.drawable.ic_fill_home,
                                        text = "Home3",
                                        id = SpecialBottom.Id("home3"),
                                    ),
                                    SpecialBottom.Item(
                                        icon = R.drawable.ic_outline_home,
                                        activatedIcon = R.drawable.ic_fill_home,
                                        text = "Home4",
                                        id = SpecialBottom.Id("home4"),
                                        badge = SpecialBottom.Badge(
                                            backgroundColor = Color.Black,
                                            textColor = Color.White
                                        )
                                    )
                                ),
                                currentSelected = itemSelected,
                                onItemSelected = { itemSelected = it },
                                theme = SpecialBottom.Theme(
                                    iconAdd = R.drawable.ic_outline_home,
                                )
                            )*/
                        },
                    ) { paddingValues ->


                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Cyan)
                                .padding(bottom = 0.dp),

                            contentAlignment = Alignment.Center
                        ) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Yellow),
                            ) {
                                items(100) {
                                    Text(
                                        text = "Item $it",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.White)
                                    )
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}

