package com.stackmobile.ca6source72396.navigation

sealed class NavRoutes(val route: String) {
    data object List : NavRoutes("list")
    data object Detail : NavRoutes("detail/{itemId}") {
        const val ARG_ITEM_ID = "itemId"
        fun build(itemId: Int) = "detail/$itemId"
    }
}
