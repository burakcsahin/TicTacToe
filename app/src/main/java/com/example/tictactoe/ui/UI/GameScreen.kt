package com.example.tictactoe.ui.UI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.tictactoe.BoardBoxValue
import com.example.tictactoe.GameVM
import com.example.tictactoe.PlayerActions
import com.example.tictactoe.ui.UI.Theme.BlueTintedWhite
import com.example.tictactoe.ui.UI.Theme.DiamondBlueBackground
import com.example.tictactoe.ui.UI.Theme.EmeraldGreen
import com.example.tictactoe.ui.UI.Theme.PureBlack
import com.example.tictactoe.ui.UI.Theme.Purple40
import com.example.tictactoe.ui.UI.Theme.Purple700
import com.example.tictactoe.ui.UI.Theme.Purple80
import com.example.tictactoe.ui.UI.Theme.Teal200
import com.example.tictactoe.State

@Composable

fun GameScreen(
    viewModel: GameVM
){
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DiamondBlueBackground)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        )
        {
            Text(text = "Player O : ${state.ovalPlayerCount}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp))
            Text(text = "Draw : ${state.drawCount}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp))
            Text(text = "Player X : ${state.carpiPlayerCount}", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp))
        }
        Text(
            text = "3T: Tic Tac Toe",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = PureBlack
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 55.dp,
                    shape = RoundedCornerShape(21.dp)
                )
                .clip(RoundedCornerShape(21.dp))
                .background(BlueTintedWhite),
            contentAlignment = Alignment.Center
        ){
            Board()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)
            ){
                viewModel.boardItems.forEach{(cellNo, boardBoxValue) ->
                    item{
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable {
                                           viewModel.onAction(
                                               PlayerActions.BoardTapped(cellNo)
                                           )
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            if (boardBoxValue == BoardBoxValue.OVAL){
                                Oval()
                            }else if(boardBoxValue == BoardBoxValue.CARPI){
                                Carpi()
                            }
                        }
                    }
                }
            }


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = state.hintText,
                fontSize = 22.sp,
                fontStyle = FontStyle.Normal
            )
            Button(
                onClick = { /* TODO*/},
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors()
            ){
                Text(text = "Play Again", fontSize = 15.sp)
            }

        }
    }
}


@Preview
@Composable
fun Prev(){
    GameScreen(
        viewModel = GameVM()
    )
}