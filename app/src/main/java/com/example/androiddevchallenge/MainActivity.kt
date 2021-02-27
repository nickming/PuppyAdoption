/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.puppyData
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                PuppyScreen() {
                    val intent = Intent(this, PuppyDetailActivity::class.java)
                    intent.putExtra("data", it)
                    startActivity(intent)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun PuppyScreen(onClick: ((Puppy) -> Unit)? = null) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Adaption") },
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(text = { Text(text = "Add") }, onClick = {

            })
        }
    ) {
        PuppyList(data = puppyData, onClick)
    }
}


@Composable
fun PuppyList(data: List<Puppy>, onClick: ((Puppy) -> Unit)? = null) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(data, { item -> item.id }) { puppy ->
            PuppyContent(puppy, onClick)
        }
    }
}

@Composable
fun PuppyContent(puppy: Puppy, onClick: ((Puppy) -> Unit)? = null) {
    Card(Modifier.clickable(onClick != null) {
        onClick?.invoke(puppy)
    }, shape = MaterialTheme.shapes.large) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(
                    id = puppy.photos.firstOrNull() ?: R.drawable.ic_launcher_background
                ),
                "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .height(height = 150.dp)
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = puppy.name,
                    style = TextStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "Age: ${puppy.age}\nCategory: ${puppy.type}",
                    style = MaterialTheme.typography.subtitle1
                )
            }

        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        PuppyScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyScreen()
    }
}
