package com.dev.hiagomartins.instagram.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dev.hiagomartins.instagram.R
import com.dev.hiagomartins.instagram.ui.theme.spacingLarge
import com.dev.hiagomartins.instagram.ui.theme.spacingSmall
import com.dev.hiagomartins.instagram.data.model.Feed
import com.dev.hiagomartins.instagram.ui.theme.Gray
import com.dev.hiagomartins.instagram.ui.theme.spacingMedium

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FeedItem(feed: Feed) {

    val likeIcon = R.drawable.ic_notification
    val messageIcon = R.drawable.ic_message
    val bookmarkIcon = R.drawable.ic_bookmark
    val commentIcon = R.drawable.ic_comment

    val userAvatarContentDesc: String = stringResource(R.string.content_description_feed_avatar)
    val feedImageContentDesc: String = stringResource(R.string.content_description_feed_image)

    val likeContentDesc: String = stringResource(R.string.button_like_content_description)
    val messageContentDesc: String = stringResource(R.string.button_message_content_description)
    val commentContentDesc: String = stringResource(R.string.button_comment_content_description)
    val bookmarkContentDesc: String = stringResource(R.string.button_bookmark_content_description)

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
            modifier = Modifier
                .padding(horizontal = spacingSmall)
                .padding(top = spacingLarge)
        ) {
            GlideImage(
                model = feed.userAvatar,
                contentDescription = userAvatarContentDesc,
                modifier = Modifier
                    .size(36.dp)
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column() {
                Text( // Texto com Nickname
                    text = feed.userNickname, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingMedium),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = feed.localName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingMedium),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )
            }
        }
        GlideImage(
            model = feed.imageUrl,
            contentDescription = feedImageContentDesc,
            modifier = Modifier
                .padding(top = spacingSmall)
                .height(256.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(start = spacingMedium)
                .padding(top = spacingLarge)
        ) {
            FeedIcon(icon = likeIcon, contentDescription = likeContentDesc)
            FeedIcon(icon = messageIcon, contentDescription = messageContentDesc)
            FeedIcon(icon = commentIcon, contentDescription = commentContentDesc)
            Image(
                painter = painterResource(id = bookmarkIcon),
                contentDescription = bookmarkContentDesc,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = spacingLarge)
                    .weight(1f)
                    .wrapContentWidth(align = Alignment.End)
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = spacingSmall)
                .padding(top = spacingLarge)
        ) {
            val description = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(feed.userNickname)
                }
                append(" ")
                append(feed.descriptionImage)
            }
            Text(
                text = description,
                modifier = Modifier.padding(horizontal = spacingMedium),
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
        }

        Text(
            text = feed.postedAgo,
            modifier = Modifier
                .padding(start = 12.dp)
                .padding(top = spacingSmall),
            maxLines = 1,
            color = Gray,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun FeedIcon(
    @DrawableRes icon: Int,
    contentDescription: String
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(40.dp)
            .padding(end = spacingLarge)
    )
}

@Preview(showBackground = true)
@Composable
fun ShowFeedItem() {
    FeedItem(
        feed = Feed(
            userNickname = "hiagopvdz",
            userAvatar = "https://avatars.githubusercontent.com/u/104175868?v=4",
            localName = "Belo Horizonte",
            imageUrl = "",
            descriptionImage = "Eu gosto de batata",
            postedAgo = "Hà 2 dias"
        )
    )
}