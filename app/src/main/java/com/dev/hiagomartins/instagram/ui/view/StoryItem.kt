package com.dev.hiagomartins.instagram.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dev.hiagomartins.instagram.R
import com.dev.hiagomartins.instagram.data.model.Story
import com.dev.hiagomartins.instagram.data.repository.stories
import com.dev.hiagomartins.instagram.ui.theme.StoryCircleColor
import com.dev.hiagomartins.instagram.ui.theme.spacingSmall

@OptIn(ExperimentalGlideComposeApi::class) // Experimental Glide Lib
@Composable
fun StoryItem(story: Story) {

    val avatarContentDesc: String = stringResource(
        id = R.string.content_description_story,
        story.userNickName
    ) // Utilizando string formatada

    Column(
        modifier = Modifier
            .padding(spacingSmall)
            .background(MaterialTheme.colorScheme.background)
    ) {
        GlideImage(
            model = story.userAvatar,
            contentDescription = avatarContentDesc,
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
                .clip(CircleShape) // corte da imagem -> neste caso imagem circular
                .border(2.dp, StoryCircleColor, CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = story.userNickName,
            modifier = Modifier.size(width = 72.dp, height = 24.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis, // acrescentar reticências.
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StoryItemPreview() {
    StoryItem(story = stories[1])
}
