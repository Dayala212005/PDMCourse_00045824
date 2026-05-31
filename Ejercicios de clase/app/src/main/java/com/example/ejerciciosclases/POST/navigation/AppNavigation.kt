package com.example.ejerciciosclases.POST.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.ejerciciosclases.POST.screens.ViewCreatePost.SavePost
import com.example.ejerciciosclases.POST.screens.ViewPost.ShowPosts

@Composable
fun PostApp() {

    val backStack = rememberNavBackStack(Routes.View)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.View> {
                ShowPosts(
                    onPost = {
                        backStack.add(Routes.Create)
                    }
                )
            }
            entry<Routes.Create> {
                SavePost(
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}