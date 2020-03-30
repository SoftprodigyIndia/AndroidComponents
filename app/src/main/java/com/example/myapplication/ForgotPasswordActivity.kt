package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.ButtonStyle
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight

class ForgotPasswordActivity : BaseActivity() {
    var username: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // sertup app layout
                appBar(title = "Jetpack Compose View ")
            }
        }
    }

    @Composable
    override fun setupView() {
        // get intent
        username = intent.getStringExtra("username")
        // set text view in center
        Center {
            Column(Spacing(10.dp)) {
                Align(alignment = Alignment.Center) {
                    Text(
                        text = "Forgot Password",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 35.sp
                        )
                    )
                }
                    HeightSpacer(40.dp)
                Align(alignment = Alignment.Center) {
                    Text(
                        text = "Dear user please enter your email id to recover your password",
                        style = TextStyle(
                            fontSize = 15.sp
                        )
                    )
                }
                HeightSpacer(20.dp)
                    Text(
                        text = "Email id",
                        style = TextStyle(
                            fontSize = 15.sp
                        )
                    )
                    HeightSpacer(10.dp)
                    StringTextFieldSample()
                    Divider(color = Color.Gray, height = 1.dp)

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
                                text = "Send Password",
                                style = ButtonStyle(
                                    textStyle = TextStyle(fontSize = (15.sp)),
                                    elevation = 5.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(8.dp),
                                    border = Border(color = Color.Gray, width = 1.dp)
                                ),
                                onClick = {
                                    val viewIntent =
                                        Intent(this@ForgotPasswordActivity, HomeActivity::class.java)
                                    startActivity(viewIntent)
                                })
                        }
                    }
                }
                }



        }
    }
}