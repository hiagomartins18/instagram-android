package com.dev.hiagomartins.instagram.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.hiagomartins.instagram.data.Story
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

        val stories = listOf(
            Story(
                userNickName = "hiagopvdz",
                userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4"
            ),
            Story(
                userNickName = "hiagopvdz",
                userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4"
            ),
            Story(
                userNickName = "hiagopvdz",
                userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4"
            ),
            Story(
                userNickName = "hiagopvdz",
                userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4"
            ),
            Story(
                userNickName = "hiagopvdz",
                userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4"
            ),
            Story(
                userNickName = "hiagopvdz",
                userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4"
            )
        )

        StoryList(stories = stories)
    }
}

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {  // LazyRow -> Recycle View Horizontal
        itemsIndexed(stories) { _, item ->  // Funciona como adapter
            StoryItem(story = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}