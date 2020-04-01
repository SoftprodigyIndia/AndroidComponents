package com.example.jetnews.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.selection.Toggleable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.jetnews.ui.home.HomeScreen
import com.example.jetnews.ui.navigateTo


class ForgotPasswordActivity : AppCompatActivity() {
    var username: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                setupView()

        }
    }

    @Composable
    private fun setupView() {
        Column() {

                Text(
                    text = "Forgot Password",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp
                    )
                )

            Spacer(LayoutHeight(40.dp))

                                    Text(
                        text = "Dear user please enter your email id to recover your password",
                        style = TextStyle(
                            fontSize = 15.sp
                        )
                    )
            Spacer(LayoutHeight(20.dp))

                    Text(
                        text = "Email id",
                        style = TextStyle(
                            fontSize = 15.sp
                        )
                    )
                Spacer(LayoutHeight(10.dp))
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
                Spacer(LayoutHeight(20.dp))


            TextButton(onClick =  {
//                Toast.makeText(
//                    this@ForgotPasswordActivity,
//                    "Item name ",
//                    Toast.LENGTH_SHORT
//                ).show()
//                navigateTo(Screen.Home)
                val viewIntent = Intent(this@ForgotPasswordActivity, MainActivity::class.java)
                startActivity(viewIntent)

            }, modifier = LayoutWidth.Fill,backgroundColor = Color.Blue) {
                                Row(arrangement = Arrangement.Center, modifier = LayoutWidth.Fill) {
                                    Text(
                                        text = "Send Password",
                                        style = (MaterialTheme.typography()).body2.copy(
                                            color =  Color.Gray
                                        )
                                    )
                                }


                        }














//        // get intent
//        username = intent.getStringExtra("username")
//        // set text view in center
//        Center {
//            Column(modifier = LayoutSize.Fill) {
//                Align(alignment = Alignment.Center) {
//                    Text(
//                        text = "Forgot Password",
//                        style = TextStyle(
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 35.sp
//                        )
//                    )
//                }
//                Spacer(LayoutHeight(40.dp))
//
//                Align(alignment = Alignment.Center) {
//                    Text(
//                        text = "Dear user please enter your email id to recover your password",
//                        style = TextStyle(
//                            fontSize = 15.sp
//                        )
//                    )
//                }
//                Spacer(LayoutHeight(20.dp))
//
//                    Text(
//                        text = "Email id",
//                        style = TextStyle(
//                            fontSize = 15.sp
//                        )
//                    )
//                Spacer(LayoutHeight(10.dp))
//
//                    StringTextFieldSample()
//                    Divider(color = Color.Gray, height = 1.dp)
//                Spacer(LayoutHeight(20.dp))
//
//                // set submit button
//                Center {
//                    Row(
//                        modifier = LayoutPadding(16.dp)
//                    ) {
//
//
//
//                            TextButton(onClick = {
//                                val viewIntent =
//                                        Intent(this@ForgotPasswordActivity, HomeScreen()::class.java)
//                                    startActivity(viewIntent)
//                            }, modifier = LayoutWidth.Fill) {
//                                Row(arrangement = Arrangement.Start, modifier = LayoutWidth.Fill) {
//                                    Text(
//                                        text = "Send Password",
//                                        style = (MaterialTheme.typography()).body2.copy(
//                                            color =  Color.Gray
//                                        )
//                                    )
//                                }
//
//
//                        }
//                    }
//                }
//                }
//
//
//
//        }
    }
        }
    @Composable
    fun StringTextFieldSample() {

        val state = state { "" }
        TextField(
            value = state.value,
            onValueChange = { state.value = it }
        )
    }

    @Composable
    fun navigateNext(){

    }

    
}