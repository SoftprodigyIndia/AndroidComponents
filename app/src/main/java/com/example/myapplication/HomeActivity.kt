package com.example.myapplication

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.Crossfade
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class HomeActivity : AppCompatActivity() {
    var username: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
Main()
        }
    }

@Composable
fun Main(){
    MaterialTheme {
val stateChange= state { DrawerState.Closed }
//        val (currentState,stateChange)=state { DrawerState.Closed }
        ModalDrawerLayout(drawerState = DrawerState.Closed,
            onStateChange = stateChange,
            drawerContent = {AppDrawer{
                (DrawerState.Closed)
            }},
            bodyContent = {Content{
                (DrawerState.Opened)
            }})
    }
}
    @Composable
    fun Content(openDrawer:()-> Unit){
        Column{
            TopAppBar(
                title={
                    Text(text = "AppBar")
                },
                color = Color.White,
                navigationIcon = {

                        openDrawer()

                }
            )
        }

    }

    @Composable
    private fun AppDrawer(
        closeDrawer: () -> Unit
    ){
        Column{
            Ripple(bounded = true) {
                Clickable(onClick = closeDrawer) {
                    Text(text = "Click me to close")
                }

            }
        }
    }










}


