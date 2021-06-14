package com.example.composeexample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexample.ui.theme.ComposeExampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                    ListOfTexts()
//                    SamesAsRecycler()
//                    ConstraintExample()
//                    AnimationExample()
//                }

                val nav = rememberNavController()
                NavHost(navController = nav , "profile"){
                    composable("profile") {
                        Profile()
                    }
                    composable("friendslist") {
                        FriendList()
                    }
                }
            }

        }
    }
}

@Composable
fun Profile(){

}

@Composable
fun FriendList(){

}


@Composable
fun ListOfTexts() {
    Column {
        Text(text = "Hello 1")
        Text(text = "Hello 222222")
        Text(text = "Hello 333333")
        Text(text = "Hello 444444444")
    }
}

@Composable
fun SamesAsRecycler() {

    LazyColumn() {
        items(100) {
            ItemCustom(id = it.toString())
        }
    }


}


@Composable
fun Greeting(name: String) {

    Text(text = name)
}

@Composable
fun ItemCustom(id: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth()
    ) {
        Greeting(name = "Pepito $id")
    }
}


@Composable
fun ConstraintExample() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBoxId")
        val blueBox = createRefFor("blueBoxId")

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(120.dp)
            height = Dimension.value(120.dp)
        }

        constrain(blueBox) {
            start.linkTo(parent.start)
            top.linkTo(greenBox.bottom)
            width = Dimension.value(120.dp)
            height = Dimension.value(120.dp)
        }

    }
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBoxId")
        ) {

        }
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .layoutId("blueBoxId")
        ) {

        }
    }

}


@Composable
fun AnimationExample() {


    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,
        tween(durationMillis = 3000, delayMillis = 300, easing = FastOutSlowInEasing)

//        spring(Spring.DampingRatioHighBouncy)

//    keyframes {
//        durationMillis = 5000
//        sizeState at 0 with LinearEasing
//        sizeState * 1.5f at 1000 with FastOutSlowInEasing
//        sizeState * 2f at 3000
//    }

    )

    val infiniteTransition = rememberInfiniteTransition()

    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable( tween( durationMillis = 2000), repeatMode = RepeatMode.Reverse)
    )



    Box(
        modifier = Modifier
            .background(color)
            .size(size), contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text(text = "Some Text")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
//        Greeting("Android")
//        ListOfTexts()
        ItemCustom("a")
    }

}