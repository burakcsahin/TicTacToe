package com.example.tictactoe

sealed class PlayerActions {
    object PlayAgainButtonClicked: PlayerActions()
    data class BoardTapped(val cellNo: Int): PlayerActions()
}