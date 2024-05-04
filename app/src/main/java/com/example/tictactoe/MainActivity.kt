package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tictactoe.ui.UI.GameScreen
import com.example.tictactoe.ui.UI.Theme.TicTacToeTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                val vm = viewModel<GameVM>()
                GameScreen(
                    viewModel = vm
                )
            }
        }
    }
}

