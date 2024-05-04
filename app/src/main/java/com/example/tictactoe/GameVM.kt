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
            if(victoryCheck(BoardBoxValue.OVAL)){
                state = state.copy(
                    hintText = "'O' WON!!",
                    ovalPlayerCount = state.ovalPlayerCount + 1,
                    currTurn = BoardBoxValue.NONE,
                    hasWon = true
                )
            }
            else if(boardFull()){
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
            if(victoryCheck(BoardBoxValue.CARPI)){
                state = state.copy(
                    hintText = "'X' WON!!",
                    carpiPlayerCount = state.carpiPlayerCount + 1,
                    currTurn = BoardBoxValue.NONE,
                    hasWon = true
                )
            }
            else if(boardFull()) {
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

    private fun victoryCheck(boardVal: BoardBoxValue): Boolean {
        when{
            boardItems[1] == boardVal && boardItems[2] == boardVal && boardItems[3] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.H1)
                return true
            }
            boardItems[4] == boardVal && boardItems[5] == boardVal && boardItems[6] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.H2)
                return true
            }
            boardItems[7] == boardVal && boardItems[8] == boardVal && boardItems[9] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.H3)
                return true
            }
            boardItems[1] == boardVal && boardItems[2] == boardVal && boardItems[3] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.H1)
                return true
            }
            boardItems[1] == boardVal && boardItems[4] == boardVal && boardItems[7] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.V1)
                return true
            }
            boardItems[2] == boardVal && boardItems[5] == boardVal && boardItems[8] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.V2)
                return true
            }
            boardItems[3] == boardVal && boardItems[6] == boardVal && boardItems[9] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.V3)
                return true
            }
            boardItems[1] == boardVal && boardItems[5] == boardVal && boardItems[9] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.D1)
                return true
            }
            boardItems[3] == boardVal && boardItems[5] == boardVal && boardItems[7] == boardVal ->{
                state = state.copy(victoryVariant = VictoryVariant.D2)
                return true
            }
        }
        return false
    }

    private fun boardFull(): Boolean {
        if(boardItems.containsValue(BoardBoxValue.NONE)){
            return false
        }
        return true
    }
}