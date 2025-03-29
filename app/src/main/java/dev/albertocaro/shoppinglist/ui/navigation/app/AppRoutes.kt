package dev.albertocaro.shoppinglist.ui.navigation.app

object AppRoutes {
    const val HOME = "home"
    const val LOGIN = "login"

    const val SHOPPING_LIST_DETAIL = "shopping_list/{id}"

    fun createShoppingListDetailRoute(id: Long) =
        SHOPPING_LIST_DETAIL.replace("{id}", id.toString())
}