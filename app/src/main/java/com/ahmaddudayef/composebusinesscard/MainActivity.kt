package com.ahmaddudayef.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmaddudayef.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    val modifier = Modifier
    Card(backgroundColor = Color(0xFFFFFFFF)) {
        ProfileInfo(
            fullName = "Ahmad Dudayef",
            title = "Android Developer",
            displayPicture = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = modifier
        )
        ContactDetails(
            phoneNumber = "08123456789",
            socialHandle = "ahmaddudayef, dudayefahmad",
            emailAddress = "ahmaddudayef@gmail.com",
            modifier = modifier
        )
    }
}

@Composable
fun ProfileInfo(fullName: String, title: String, displayPicture: Painter, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 192.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = displayPicture,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color(0xFF85E295)),
            modifier = modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(1.dp, Color(0xFFDBD3D8), CircleShape)
        )
        Text(text = fullName, style = TextStyle(fontSize = 48.sp, color = Color(0xFF223843)))
        Text(text = title, style = TextStyle(fontSize = 16.sp, color = Color(0xFF85E295)))
    }
}

@Composable
fun ContactDetails(
    phoneNumber: String,
    socialHandle: String,
    emailAddress: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp)
            .width(intrinsicSize = IntrinsicSize.Min),
        verticalArrangement = Arrangement.Bottom,
    ) {

        Divider(
            color = Color(0xFFDBD3D8),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 1.dp
        )

        Row(
            modifier = modifier
                .padding(horizontal = 64.dp)
                .padding(bottom = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = null,
                tint = Color(0xFF85E295)
            )
            Text(
                text = phoneNumber,
                modifier = modifier.padding(start = 32.dp),
                style = TextStyle(color = Color(0xFF223843))
            )
        }

        Divider(
            color = Color(0xFFDBD3D8),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 1.dp
        )

        Row(
            modifier = modifier
                .padding(horizontal = 64.dp)
                .padding(bottom = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null,
                tint = Color(0xFF85E295)
            )
            Text(
                text = socialHandle,
                modifier = modifier.padding(start = 32.dp),
                style = TextStyle(color = Color(0xFF223843))
            )
        }

        Divider(
            color = Color(0xFFDBD3D8),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 1.dp
        )

        Row(
            modifier = modifier
                .padding(horizontal = 64.dp)
                .padding(bottom = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
                tint = Color(0xFF85E295)
            )
            Text(
                text = emailAddress,
                modifier = modifier.padding(start = 32.dp),
                style = TextStyle(color = Color(0xFF223843))
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeBusinessCardTheme {
        BusinessCardApp()
    }
}