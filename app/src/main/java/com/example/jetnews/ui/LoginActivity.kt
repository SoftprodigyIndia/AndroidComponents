package com.example.jetnews.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Border
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.jetnews.R


class LoginActivity : AppCompatActivity() {
    var strPassword: String = ""
    var strUserName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         setupView()
        }
    }



    @Composable
    private fun setupView() {


            Column {



                Spacer(LayoutHeight(50.dp))
                Container(modifier = LayoutGravity.Center + LayoutSize(80.dp, 80.dp)) {
                    Clip(CircleShape) {
                        VectorImage(id = R.drawable.ic_launcher_background)
                    }
                }






                Row(arrangement = Arrangement.Center, modifier = LayoutWidth.Fill) {
                    Text(
                        text = "Sign in",
                        style = TextStyle(
                            fontSize = 35.sp
                        )
                    )
                }


                for (i in 0..1) {
                    Spacer(LayoutHeight(10.dp))
                    if (i == 0)
                        Text(text = "Username")
                    else
                        Text(text = "Password")
                    Spacer(LayoutHeight(3.dp))
                    setEditText(i)
                }

                Spacer(LayoutHeight(20.dp))                // set submit button

                    Row(arrangement = Arrangement.Start, modifier = LayoutWidth.Fill) {


                                                TextButton(
                                                    onClick = {
                                                        val viewIntent =
                                                            Intent(this@LoginActivity, MainActivity::class.java)
                                                        viewIntent.putExtra("username", strUserName)
                                                        startActivity(viewIntent)
                                                    },modifier = LayoutWidth.Fill,backgroundColor = Color.Blue){
                                                    Row(arrangement = Arrangement.Center,modifier = LayoutWidth.Fill) {
                                                        Text(text = "Login",
                                                            style = (MaterialTheme.typography()).body2.copy(
                                                                color =  Color.Gray
                                                            )
                                                        )
                                                    }
                                                }





















                    }


                Spacer(LayoutHeight(20.dp))

                    Clickable(onClick = {
                        val viewIntent =
                            Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                        startActivity(viewIntent)
                    }) {
                        Text(text = "Forgot Password",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }



                Spacer(LayoutHeight(20.dp))


                    Clickable(onClick = {
                        val viewIntent =
                            Intent(this@LoginActivity, RegisterationActivity::class.java)
                        startActivity(viewIntent)
                    }) {
                        Text(text = "Create a new account",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }


            }

    }

    @Composable
    private fun setEditText(isPassword: Int) {

            Card(
                shape = RoundedCornerShape(size = 8.dp),
                border = Border(1.dp,color = Color.Gray)
            ) {
                Column{
                    val state = state { ("") }
                    TextField(
                        imeAction = ImeAction.Next,
                        value = state.value,
                        onValueChange = {
//                            state.value = it
                            if (isPassword == 0) {
                                strUserName = state.value
                            } else {
                                strPassword = state.value
                            }
                        }

                    )
                }

        }
    }



}