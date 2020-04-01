package com.example.jetnews.ui

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.sp
import com.example.jetnews.ui.interests.SelectTopicButton

/*
 * Copyright 2019 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Clip
import androidx.ui.core.Opacity
import androidx.ui.core.Text
import androidx.ui.foundation.Box
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.selection.Toggleable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.jetnews.R
import com.example.jetnews.data.people
import com.example.jetnews.data.publications
import com.example.jetnews.data.topics




@Composable
fun ProfileActivity(scaffoldState: ScaffoldState = remember { ScaffoldState() }) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                currentScreen = Screen.ProfileActivity,
                closeDrawer = { scaffoldState.drawerState = DrawerState.Closed }
            )
        },
        topAppBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    VectorImageButton(R.drawable.ic_jetnews_logo) {
                        scaffoldState.drawerState = DrawerState.Opened
                    }
                }
            )
        },
        bodyContent = {

            ProfileScreenBody()
        }
    )
}

@Composable
private fun ProfileScreenBody(){

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


        TextButton(onClick = {
            //                Toast.makeText(
//                    this@ForgotPasswordActivity,
//                    "Item name ",
//                    Toast.LENGTH_SHORT
//                ).show()
//                navigateTo(Screen.Home)
//            val viewIntent = Intent(this@ForgotPasswordActivity, MainActivity::class.java)
//            startActivity(viewIntent)

        }, modifier = LayoutWidth.Fill, backgroundColor = Color.Blue) {
            Row(arrangement = Arrangement.Center, modifier = LayoutWidth.Fill) {
                Text(
                    text = "Send Password",
                    style = (MaterialTheme.typography()).body2.copy(
                        color = Color.Gray
                    )
                )
            }


        }
    }
}



@Composable
private fun TopicsTab() {
    TabWithSections(
        "Topics",
        topics
    )
}





@Composable
private fun TabWithTopics(tabName: String, topics: List<String>) {
    VerticalScroller {
        Column(modifier = LayoutPadding(top = 16.dp)) {
            topics.forEach { topic ->
                TopicItem(
                    getTopicKey(
                        tabName,
                        "- ",
                        topic
                    ),
                    topic
                )
                TopicDivider()
            }
        }
    }
}

@Composable
private fun TabWithSections(
    tabName: String,
    sections: Map<String, List<String>>
) {
    VerticalScroller {
        Column {
            sections.forEach { (section, topics) ->
                Text(
                    text = section,
                    modifier = LayoutPadding(16.dp),
                    style = (MaterialTheme.typography()).subtitle1)
                topics.forEach { topic ->
                    TopicItem(
                        getTopicKey(
                            tabName,
                            section,
                            topic
                        ), topic
                    )
                    TopicDivider()
                }
            }
        }
    }
}

@Composable
private fun TopicItem(topicKey: String, itemTitle: String) {
    val image = imageResource(R.drawable.placeholder_1_1)

    Ripple(bounded = true) {
        val selected = isTopicSelected(topicKey)
        val onSelected = { it: Boolean ->
            selectTopic(topicKey, it)
        }
        Toggleable(selected, onSelected) {
            // TODO(b/150060763): Remove box after "Bug in ripple + modifiers."
            Box {
                Row(
                    modifier = LayoutPadding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 0.dp)
                ) {
                    Container(modifier = LayoutGravity.Center + LayoutSize(56.dp, 56.dp)) {
                        Clip(RoundedCornerShape(4.dp)) {
                            SimpleImage(image = image)
                        }
                    }
                    Text(
                        text = itemTitle,
                        modifier = LayoutFlexible(1f) + LayoutGravity.Center + LayoutPadding(16.dp),
                        style = (MaterialTheme.typography()).subtitle1
                    )
                    SelectTopicButton(
                        modifier = LayoutGravity.Center,
                        selected = selected
                    )
                }
            }
        }
    }
}

@Composable
private fun TopicDivider() {
    Opacity(0.08f) {
        Divider(LayoutPadding(start = 72.dp, top = 8.dp, end = 0.dp, bottom = 8.dp))
    }
}

private fun getTopicKey(tab: String, group: String, topic: String) = "$tab-$group-$topic"

private fun isTopicSelected(key: String) = JetnewsStatus.selectedTopics.contains(key)

private fun selectTopic(key: String, select: Boolean) {
    if (select) {
        JetnewsStatus.selectedTopics.add(key)
    } else {
        JetnewsStatus.selectedTopics.remove(key)
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    ProfileActivity()
}

@Preview
@Composable
private fun PreviewDrawerOpen() {
    ProfileActivity(scaffoldState = ScaffoldState(drawerState = DrawerState.Opened))
}

@Preview
@Composable
fun PreviewTopicsTab() {
    TopicsTab()
}

@Preview
@Composable
fun PreviewPeopleTab() {

}

@Preview
@Composable
fun PreviewTabWithTopics() {
    TabWithTopics(tabName = "preview", topics = listOf("Hello", "Compose"))
}
