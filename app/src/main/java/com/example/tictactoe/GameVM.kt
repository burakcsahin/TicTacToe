package com.example.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameVM: ViewModel() {
    var state by mutableStateOf(State())

    val boardItems: MutableMap<Int, BoardBoxValue> = mutableMapOf(
        1 to BoardBoxValue.NONE,
        2 to BoardBoxValue.NONE,
        3 to BoardBoxValue.NONE,
        4 to BoardBoxValue.NONE,
        5 to BoardBoxValue.NONE,
        6 to BoardBoxValue.NONE,
        7 to BoardBoxValue.NONE,
        8 to BoardBoxValue.NONE,
        9 to BoardBoxValue.NONE,

        )
    fun onAction(action: PlayerActions){
        when(action){
            is PlayerActions.BoardTapped -> {
                addValueToBoard(action.cellNo)

            }
            PlayerActions.PlayAgainButtonClicked -> {
                gameRes()
            }
        }
    }

    private fun gameRes() {
        for ((key, _) in boardItems) {
            boardItems[key] = BoardBoxValue.NONE
        }
        state = state.copy(
            hintText = "Turn of Player 'O'",
            currTurn = BoardBoxValue.OVAL,
            victoryVariant = VictoryVariant.NONE,
            hasWon = false
        )


    }

    private fun addValueToBoard(cellNo: Int) {
        if(boardItems[cellNo] != BoardBoxValue.NONE){
            return
        }
        if(state.currTurn == BoardBoxValue.OVAL){
            boardItems[cellNo] = BoardBoxValue.OVAL
            if(boardFull()){
                state = state.copy(
                    hintText = "Draw",
                    drawCount = state.drawCount + 1
                )
            }else{
                state = state.copy(
                    hintText = "Turn of Player 'X'",
                    currTurn = BoardBoxValue.CARPI)
            }
        }else if(state.currTurn == BoardBoxValue.CARPI){
            boardItems[cellNo] = BoardBoxValue.CARPI
            if(boardFull()) {
                state = state.copy(
                    hintText = "Draw",
                    drawCount = state.drawCount + 1
                )
            }else{
                state = state.copy(
                    hintText = "Turn of Player 'O'",
                    currTurn = BoardBoxValue.OVAL
                )
            }

        }
    }

    private fun boardFull(): Boolean {
        if(boardItems.containsValue(BoardBoxValue.NONE)){
            return false
        }
        return true
    }
}