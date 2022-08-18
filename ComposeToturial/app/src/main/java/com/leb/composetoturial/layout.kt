package com.leb.composetoturial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leb.composetoturial.ui.theme.ComposeToturialTheme

@Composable
fun PhotographerCard() {
    Row() {
        Surface(modifier = Modifier.size(50.dp), shape = CircleShape,color=MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)) {

        }
        Column(modifier = Modifier
            .padding(start = 8.dp)
            .align(Alignment.CenterVertically)) {
            Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider() {
                Text("3 minutes ago.", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPhotographerCard() {
    ComposeToturialTheme() {
        PhotographerCard()
    }
}