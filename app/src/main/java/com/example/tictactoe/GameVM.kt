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

            }
        }
    }

    private fun addValueToBoard(cellNo: Int) {
        if(boardItems[cellNo] != BoardBoxValue.NONE){
            return
        }
        if(state.currTurn == BoardBoxValue.OVAL){
            boardItems[cellNo] = BoardBoxValue.OVAL
            state = state.copy(
                hintText = "Player 'X' turn",
                currTurn = BoardBoxValue.CARPI
            )
        }else if(state.currTurn == BoardBoxValue.CARPI){
            boardItems[cellNo] = BoardBoxValue.CARPI
            state = state.copy(
                hintText = "Player 'O' turn",
                currTurn = BoardBoxValue.OVAL
            )
        }
    }
}