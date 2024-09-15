package ru.plumsoftware.csgotest.start_point

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yandex.mobile.ads.appopenad.AppOpenAd
import com.yandex.mobile.ads.appopenad.AppOpenAdEventListener
import com.yandex.mobile.ads.appopenad.AppOpenAdLoadListener
import com.yandex.mobile.ads.appopenad.AppOpenAdLoader
import com.yandex.mobile.ads.common.AdError
import com.yandex.mobile.ads.common.AdRequestConfiguration
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.common.MobileAds
import org.koin.androidx.compose.koinViewModel
import ru.plumsoftware.csgotest.presentation.constants.IDs
import ru.plumsoftware.csgotest.presentation.constants.Routes
import ru.plumsoftware.csgotest.presentation.general.GeneralViewModel
import ru.plumsoftware.csgotest.presentation.general.store.GeneralIntent
import ru.plumsoftware.csgotest.presentation.general.store.GeneralLabel
import ru.plumsoftware.csgotest.presentation.main_screen.MainScreen
import ru.plumsoftware.csgotest.presentation.main_screen.MainViewModel
import ru.plumsoftware.csgotest.presentation.theme.CsGoTheTestGameTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val generalViewModel: GeneralViewModel = koinViewModel()
            val navHostController = rememberNavController()

            LaunchedEffect(key1 = Unit) {
                generalViewModel.label.collect { label ->
                    when (label) {
                        GeneralLabel.DismissDialog -> {
                            navHostController.clearBackStack(route = Routes.PROGRESS_DIALOG)
                        }

                        GeneralLabel.ShowDialog -> {
                            navHostController.navigate(route = Routes.PROGRESS_DIALOG)
                        }
                    }
                }
            }

            MobileAds.initialize(this@MainActivity) {
                val appOpenAdLoadListener = object : AppOpenAdLoadListener {
                    override fun onAdFailedToLoad(error: AdRequestError) {
                        generalViewModel.onIntent(GeneralIntent.ChangeAppOpenLoadingState(false))
                    }

                    override fun onAdLoaded(appOpenAd: AppOpenAd) {
                        generalViewModel.onIntent(GeneralIntent.ChangeAppOpenLoadingState(false))
                        appOpenAd.setAdEventListener(object : AppOpenAdEventListener {
                            override fun onAdClicked() {}

                            override fun onAdDismissed() {}

                            override fun onAdFailedToShow(adError: AdError) {}

                            override fun onAdImpression(impressionData: ImpressionData?) {}

                            override fun onAdShown() {}

                        })
                        appOpenAd.show(this@MainActivity)
                    }
                }

                val appOpenLoader = AppOpenAdLoader(this@MainActivity)
                appOpenLoader.setAdLoadListener(appOpenAdLoadListener)
                appOpenLoader.loadAd(
                    AdRequestConfiguration.Builder(IDs.APP_OPEN_ADS_UNIT_ID).build()
                )
            }

            CsGoTheTestGameTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navHostController,
                        startDestination = Routes.MAIN
                    ) {
                        composable(route = Routes.MAIN) {
                            val mainViewModel: MainViewModel = koinViewModel()
                            MainScreen(
                                state = mainViewModel.state.collectAsState(),
                                onMainIntent = mainViewModel::onIntent
                            )
                        }
                        composable(route = Routes.PROGRESS_DIALOG) {
                            Card(
                                modifier = Modifier.size(width = 144.dp, height = 144.dp),
                                shape = MaterialTheme.shapes.medium,
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(all = 24.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
