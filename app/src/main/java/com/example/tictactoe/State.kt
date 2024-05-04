package com.example.tictactoe

data class State(
    val ovalPlayerCount: Int = 0,
    val carpiPlayerCount: Int = 0,
    val drawCount: Int = 0,
    val hintText: String = "Turn of Player 'O'",
    val currTurn: BoardBoxValue = BoardBoxValue.OVAL,
    val victoryVariant: VictoryVariant = VictoryVariant.NONE,
    val hasWon: Boolean = false
)

enum class BoardBoxValue{
    OVAL,
    CARPI,
    NONE
}

enum class VictoryVariant{
    H1,
    H2,
    H3,
    V1,
    V2,
    V3,
    D1,
    D2,
    NONE
}