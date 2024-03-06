package com.danielubeda.rickymortyapi.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.danielubeda.rickymortyapi.ui.navigation.AppNavigator
import com.danielubeda.rickymortyapi.ui.theme.RickyMortyApiTheme
import com.danielubeda.rickymortyapi.ui.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyMortyApiTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val viewModel: CharacterViewModel = viewModel()
    val navController = rememberNavController()
    AppNavigator(navController = navController, viewModel = viewModel)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyApiTheme {
        MainContent()
    }
}
