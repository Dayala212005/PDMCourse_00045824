package com.example.parcial2pdm.MainNavegation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.parcial2pdm.screens.OptionsScreen.OptionsScreen
import com.example.parcial2pdm.screens.Results.ResultScreen
import com.example.parcial2pdm.screens.home.HomeScreen


@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    navigateToResults = {backStack.add(Routes.Results)},
                    navigateToOptions = {backStack.add(Routes.Options)}
                )
            }
            entry<Routes.Results> {
                ResultScreen(
                    navigateBack = {backStack.removeLastOrNull()}
                )
            }
            entry<Routes.Options> {
                OptionsScreen(
                    navigateBack = {backStack.removeLastOrNull()}
                )
            }
        },
    )
}