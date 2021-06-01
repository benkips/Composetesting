package com.mabnets.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mabnets.composetesting.ui.theme.ComposetestingTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scafoldstate= rememberScaffoldState()
            var textfieldstate by remember{
                mutableStateOf("")
            }
            val scope= rememberCoroutineScope()
            Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState =scafoldstate
            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ){
                TextField(
                    value =textfieldstate ,
                    label = {
                        Text(text ="Enter your name" )
                    },
                    onValueChange = {
                        textfieldstate=it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()

                    )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        scafoldstate.snackbarHostState.showSnackbar(
                            message = "hello $textfieldstate"
                        )
                    }

                }) {
                    Text(text = "please great me")
                }
            }
            }
        }

    }
}

