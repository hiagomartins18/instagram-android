package com.dev.hiagomartins.instagram.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.hiagomartins.instagram.data.model.Feed
import com.dev.hiagomartins.instagram.data.model.Story
import com.dev.hiagomartins.instagram.data.repository.feedList
import com.dev.hiagomartins.instagram.data.repository.stories
import com.dev.hiagomartins.instagram.ui.theme.DividerColor
import com.dev.hiagomartins.instagram.ui.theme.spacingMedium

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 20.dp)
    ) { //Linear Layout com orientação vertical | Continua sendo exibido um do lado do outro.
        InstagramToolbar()
        StoryList(stories = stories)
        Divider(color = DividerColor, thickness = 0.2.dp) // Cria uma linha divisória
        FeedList(feedList = feedList)
    }
}

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {  // LazyRow -> Recycle View Horizontal -> Componente
        itemsIndexed(stories) { _, item ->  // Funciona como adapter -> map
            StoryItem(story = item)
        }
    }
}

@Composable
fun FeedList(feedList: List<Feed>) {
    LazyColumn(modifier = Modifier.padding(top = spacingMedium)) {  // LazyColumn -> Recycle View Vertical -> Componente
        itemsIndexed(feedList) { _, item ->  // Funciona como adapter -> map
            FeedItem(feed = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}