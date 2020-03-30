package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle

abstract class BaseActivity : AppCompatActivity() {

    @Composable
    fun appBar(title: String) {
        FlexColumn {
            inflexible {
//                TopAppBar(title = {
//                    Center {
//                        // add text in center
//                        Text(
//                            text = title,
//                            style = TextStyle(color = Color.White)
//                        )
//                    }
//                })
            }
            setupView()
        }
    }



    @Composable
    abstract fun setupView()

}