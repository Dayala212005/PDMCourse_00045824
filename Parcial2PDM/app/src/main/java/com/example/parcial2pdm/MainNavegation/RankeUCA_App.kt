package com.example.parcial2pdm.MainNavegation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.parcial2pdm.screens.OptionsScreen.OptionsScreen
import com.example.parcial2pdm.screens.QuestionScreen.QuestionsScreen
import com.example.parcial2pdm.screens.home.HomeScreen

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Questions)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Questions> {
                QuestionsScreen(
                    onQuestionClick = { questionId ->
                        backStack.add(Routes.Home(questionId))
                    },
                    onManageOptions = { questionId ->
                        backStack.add(Routes.Options(questionId))
                    }
                )
            }
            entry<Routes.Home> { entry ->
                HomeScreen(
                    questionId = entry.questionId,
                    navigateToQuestions = { backStack.removeLastOrNull() }
                )
            }
            entry<Routes.Options> { entry ->
                OptionsScreen(
                    questionId = entry.questionId,
                    navigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}