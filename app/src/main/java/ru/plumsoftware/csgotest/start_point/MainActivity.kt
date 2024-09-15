package ru.plumsoftware.csgotest.start_point

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yandex.mobile.ads.common.MobileAds
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.plumsoftware.csgotest.presentation.Routes
import ru.plumsoftware.csgotest.presentation.main_screen.MainScreen
import ru.plumsoftware.csgotest.presentation.main_screen.MainViewModel
import ru.plumsoftware.csgotest.presentation.theme.CsGoTheTestGameTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        MobileAds.initialize(this@MainActivity) {}

        setContent {
            CsGoTheTestGameTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val navHostController = rememberNavController()
                    NavHost(navController = navHostController, startDestination = Routes.MAIN) {
                        composable(route = Routes.MAIN) {
                            val mainViewModel: MainViewModel = koinViewModel()
                            MainScreen(
                                state = mainViewModel.state.collectAsState(),
                                onMainIntent = mainViewModel::onIntent
                            )
                        }
                    }
                }
            }
        }
    }
}
