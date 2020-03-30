package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.ButtonStyle
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight

class RegisterationActivity : BaseActivity() {
    var username: String? = ""
    var strPassword: String = ""
    var strUserName: String = ""
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
        VerticalScroller {
        Column(Spacing(10.dp)) {

            HeightSpacer(10.dp)
            Text(
                text = "First name",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)

            HeightSpacer(10.dp)
            Text(
                text = "Last name",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)

            HeightSpacer(10.dp)
            Text(
                text = "Password",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)

            HeightSpacer(10.dp)
            Text(
                text = "Mobile",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)

            HeightSpacer(10.dp)
            Text(
                text = "Email id",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)

            HeightSpacer(10.dp)
            Text(
                text = "Age",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
            StringTextFieldSample()
            Divider(color = Color.Gray, height = 1.dp)

            HeightSpacer(10.dp)
            Text(
                text = "Height",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            HeightSpacer(5.dp)
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
                            text = "Register",
                            style = ButtonStyle(
                                textStyle = TextStyle(fontSize = (15.sp)),
                                elevation = 5.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(8.dp),
                                border = Border(color = Color.Gray, width = 1.dp)
                            ),
                            onClick = {
                                val viewIntent =
                                    Intent(this@RegisterationActivity, HomeActivity::class.java)
                                viewIntent.putExtra("username", strUserName)
                                startActivity(viewIntent)
                            })
                    }
                }
            }

            HeightSpacer(20.dp)
            Text(
                text = "* Dear user above fields are mendatory so please fill them correctly",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
        }
    }
            }
        }


@Composable
fun StringTextFieldSample() {

    val state = +state { "" }
    TextField(
        value = state.value,
        onValueChange = { state.value = it }
    )
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
//                                strUserName = state.value.text
                            } else {
//                                strPassword = state.value.text
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
