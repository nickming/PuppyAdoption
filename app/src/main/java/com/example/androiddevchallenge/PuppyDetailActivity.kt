package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class PuppyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy = intent.getParcelableExtra<Puppy>("data") ?: run {
            finish()
            return
        }
        setContent {
            MyTheme() {
                PuppyDetailPage(puppy) {
                    finish()
                }
            }
        }
    }
}

@Composable
fun PuppyDetailPage(puppy: Puppy, onClickBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = puppy.name) },
                navigationIcon = {
                    IconButton(
                        onClick = onClickBack
                    ) {
                        Icon(Icons.Default.ArrowBack, "", tint = MaterialTheme.colors.secondary)
                    }
                })
        }
    ) {
        val padding = Modifier.padding(16.dp, 0.dp, 10.dp, 0.dp)
        Column {
            Image(
                painter = painterResource(id = puppy.photos.first()),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Age: ${puppy.age}", modifier = padding)
            Text(text = "Category: ${puppy.type}", modifier = padding)
            Text(text = "Description: ${puppy.description}", modifier = padding)
        }
    }
}