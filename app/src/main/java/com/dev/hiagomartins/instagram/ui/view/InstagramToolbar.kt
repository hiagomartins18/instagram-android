package com.dev.hiagomartins.instagram.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.hiagomartins.instagram.R
import com.dev.hiagomartins.instagram.ui.theme.spacingLarge
import com.dev.hiagomartins.instagram.ui.theme.spacingMedium

@Composable
fun InstagramToolbar() {

    val instagramLabel : String = stringResource(id = R.string.app_name)


    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
            Modifier
                .padding(horizontal = spacingLarge)
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { // Layout em Linha
            Text(
                text = instagramLabel,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.headlineLarge
            ) // TextView
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = spacingMedium),
                contentDescription = stringResource(R.string.content_description_notification_icon)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_message),
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = spacingMedium),
                contentDescription = stringResource(R.string.content_description_message_notification)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun InstagramToolbarPreview() {
    InstagramToolbar()
}