package com.leb.composetoturial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leb.composetoturial.data.Message
import com.leb.composetoturial.data.SampleData
import com.leb.composetoturial.ui.theme.ComposeToturialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToturialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android.Google")
//                    MessageCard(msg = Message("ZhangSan", "Beijing Welcome you!!!"))
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}


@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.mipmap.default_avatar),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        //we keep track if the message is expanded or not in this varable
        var isExpanded by remember {
            mutableStateOf(false)
        }
        //surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(if(isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )
        //we toggle the isExpaned variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author, color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            androidx.compose.material3.Surface(
                shape = MaterialTheme.shapes.medium,
                color = surfaceColor,
                shadowElevation = 1.dp,
            ) {
                Text(
                    text = msg.body, modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                )
            }

        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeToturialTheme() {
        Conversation(messages = SampleData.conversationSample)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeToturialTheme() {
        MessageCard(msg = Message("ZhangSan", "Beijing Welcome you!"))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeToturialTheme {
        Greeting("Android,Java")
    }
}