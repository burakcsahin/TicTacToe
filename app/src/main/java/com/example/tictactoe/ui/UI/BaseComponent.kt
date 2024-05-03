package com.example.tictactoe.ui.UI

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoe.ui.UI.Theme.EmeraldGreen
import com.example.tictactoe.ui.UI.Theme.OrangeColor

@Composable

fun Board(){
    Canvas(
        modifier = Modifier
            .size(310.dp)
            .padding(10.dp)
    ){
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/3, y=0f),
            end = Offset(x = size.width*1/3, y=size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*2/3, y=0f),
            end = Offset(x = size.width*2/3, y=size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y=size.height*1/3),
            end = Offset(x = size.width, y=size.height*1/3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y=size.height*2/3),
            end = Offset(x = size.width, y=size.height*2/3)
        )
    }

}

@Composable
fun Carpi(){
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ){
        drawLine(
            color = OrangeColor,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x= 0f, y= 0f),
            end = Offset(x = size.width, y= size.height)
        )
        drawLine(
            color = OrangeColor,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x= 0f, y= size.height),
            end = Offset(x = size.width, 0f)
        )
    }
}

@Composable
fun Oval(){
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ){
        drawCircle(
            color = EmeraldGreen,
            style = Stroke(width = 20f)
        )

    }
}

//Win marking line scenarios
@Composable
fun horizontalWin1(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*1/6),
            end = Offset(x = size.width, y = size.height*1/6)
        )
    }
}

@Composable
fun horizontalWin2(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*3/6),
            end = Offset(x = size.width, y = size.height*3/6)
        )
    }
}

@Composable
fun horizontalWin3(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*5/6),
            end = Offset(x = size.width, y = size.height*5/6)
        )
    }
}

@Composable
fun verticalWin1(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/6, y=0f),
            end = Offset(x = size.width*1/6, y=size.height)
        )
    }
}

@Composable
fun verticalWin2(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*3/6, y=0f),
            end = Offset(x = size.width*3/6, y=size.height)
        )
    }
}

@Composable
fun verticalWin3(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*5/6, y=0f),
            end = Offset(x = size.width*5/6, y=size.height)
        )
    }
}

@Composable
fun diogonalWin1(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y=0f),
            end = Offset(x = size.width, y=size.height)
        )
    }
}
@Composable
fun diogonalWin2(){
    Canvas(
        modifier = Modifier.size(300.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y=size.height),
            end = Offset(x = size.width, y=0f)
        )
    }
}

@Preview
@Composable
fun Preview(){
    horizontalWin1()
    horizontalWin2()
    horizontalWin3()
    verticalWin1()
    verticalWin2()
    verticalWin3()
    diogonalWin1()
    diogonalWin2()
}