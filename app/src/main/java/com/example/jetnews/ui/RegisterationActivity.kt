package com.example.jetnews.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.Border
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp

class RegisterationActivity : AppCompatActivity() {
    var username: String? = ""
    var strPassword: String = ""
    var strUserName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // sertup app layout
//                appBar(title = "Jetpack Compose View ")
                setupView()
            }
        }
    }

    @Composable
    private fun setupView() {
        // get intent
        username = intent.getStringExtra("username")
        // set text view in center
        VerticalScroller {
        Column(modifier = LayoutSize.Fill) {
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "First name",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))

            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "Last name",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))

            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "Password",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))

            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "Mobile",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))

            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "Email id",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))

            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "Age",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))

            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(10.dp))

            Text(
                text = "Height",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Spacer(LayoutHeight(5.dp))
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)
            Spacer(LayoutHeight(20.dp))

            // set submit button
            Center {
                Row(
                    modifier = LayoutPadding(16.dp)
                )

                    {
                        TextButton( onClick = {
                            val viewIntent =
                                Intent(this@RegisterationActivity, LoginActivity::class.java)
                            viewIntent.putExtra("username", strUserName)
                            startActivity(viewIntent)
                        }, modifier = LayoutWidth.Fill){
                            Text(
                                text = "Register",
                                style = (MaterialTheme.typography()).body2.copy(
                                    color =  Color.Gray
                                )
                            )
                        }

                    }
                }
            }
            Spacer(LayoutWidth(20.dp))

            Text(
                text = "* Dear user above fields are mendatory so please fill them correctly",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
        }
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



