package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Surface
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.core.content.ContextCompat.startActivity
import androidx.ui.animation.Crossfade
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow

import androidx.ui.tooling.preview.Preview
import java.io.Serializable



class MainActivity : BaseActivity() {
    var strPassword: String = ""
    var strUserName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // sertup app layout
                appBar(title = "Jetpack Compose Base")

            }
        }
    }



    @Composable
    override fun setupView() {
        Center {

            Column(Spacing(10.dp)) {

                Align(alignment = Alignment.Center) {
                    Text(
                        text = "Sign in",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 35.sp
                        )
                    )
                }

                for (i in 0..1) {
                    HeightSpacer(10.dp)
                    if (i == 0)
                        Text(text = "Enter Username")
                    else
                        Text(text = "Enter Password")
                    HeightSpacer(3.dp)
                    setEditText(i)
                }

                HeightSpacer(20.dp)
                // set submit button
                Center {
                    FlexRow(
                        crossAxisSize = LayoutSize.Expand,
                        mainAxisSize = LayoutSize.Expand
                    ) {
                        expanded(1f)
                        {
                            Button(
                                text = "Login",
                                style = ButtonStyle(
                                    textStyle = TextStyle(fontSize = (15.sp)),
                                    elevation = 5.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(8.dp),
                                    border = Border(color = Color.Gray, width = 1.dp)
                                ),
                                onClick = {
                                    val viewIntent =
                                        Intent(this@MainActivity, HomeActivity::class.java)
                                    viewIntent.putExtra("username", strUserName)
                                    startActivity(viewIntent)
                                })
                        }
                    }
                }
                HeightSpacer(20.dp)
                Align(alignment = Alignment.CenterRight) {
                    Clickable(onClick = {
                        val viewIntent =
                            Intent(this@MainActivity, ForgotPasswordActivity::class.java)
                        startActivity(viewIntent)
                    }) {
                        Text(text = "Forgot Password",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }



                HeightSpacer(20.dp)
                Align(alignment = Alignment.Center) {
                    Clickable(onClick = {
                        val viewIntent =
                            Intent(this@MainActivity, RegisterationActivity::class.java)
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
        }
    }

    @Composable
    private fun setEditText(isPassword: Int) {
        Center {
            Card(
                shape = RoundedCornerShape(size = 8.dp),
                border = Border(color = Color.Gray, width = 1.dp)
            ) {
                Column(
                    mainAxisSize = LayoutSize.Expand,
                    mainAxisAlignment = MainAxisAlignment.Center,
                    modifier = Spacing(10.dp)
                ) {
                    val state = +state { EditorModel("") }
                    TextField(
                        imeAction = ImeAction.Next,
                        value = state.value,
                        onValueChange = {
                            state.value = it
                            if (isPassword == 0) {
                                strUserName = state.value.text
                            } else {
                                strPassword = state.value.text
                            }
                        },
                        editorStyle = EditorStyle(
                            textStyle = TextStyle(
                                fontSize = (15.sp)
                            )
                        )
                    )
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Column(Spacing(top = 16.dp)) {
            Text(text = "Hello $name!")
        }
    }
}


