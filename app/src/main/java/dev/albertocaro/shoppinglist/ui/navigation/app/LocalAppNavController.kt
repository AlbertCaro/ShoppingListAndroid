package dev.albertocaro.shoppinglist.ui.navigation.app

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController

val LocalAppNavController = staticCompositionLocalOf<NavController> {
    error("NavController unavailable")
}