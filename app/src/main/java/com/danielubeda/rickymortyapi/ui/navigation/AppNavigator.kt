package com.danielubeda.rickymortyapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.danielubeda.rickymortyapi.ui.view.CharacterDetailScreen
import com.danielubeda.rickymortyapi.ui.view.CharacterListScreen
import com.danielubeda.rickymortyapi.ui.viewmodel.CharacterViewModel

@Composable
fun AppNavigator(navController: NavHostController, viewModel: CharacterViewModel) {
    NavHost(navController = navController, startDestination = NavRoutes.CharacterList) {
        composable(NavRoutes.CharacterList) {
            CharacterListScreen(
                characters = viewModel.characters.collectAsState().value
            ) { characterId ->
                navController.navigate("${NavRoutes.CharacterDetail}/$characterId")
            }
        }
        composable(
            route = "${NavRoutes.CharacterDetail}/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId")
            characterId?.let {
                viewModel.getCharacterById(it)?.let { character ->
                    CharacterDetailScreen(character = character, navController = navController)
                }
            }
        }
    }
}