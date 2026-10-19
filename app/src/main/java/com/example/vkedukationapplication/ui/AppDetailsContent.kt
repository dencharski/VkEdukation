package com.example.vkedukationapplication.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedukationapplication.domain.SimilarApp
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

@Composable
fun AppDetailsContent(
) {
    Box (
        modifier = Modifier.fillMaxSize()
        )
    {

        SimilarApps(
            apps = List(9) { index ->
                SimilarApp(
                    id = "similar-app-$index",
                    name = "Гильдия Героев: Экшен ММО РПГ: $index",
                    iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                )
            },
            onItemClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(all=16.dp)

        )
    }
}

@Preview
@Composable
private fun AppDetailsContentPreview() {
    VkEdukationApplicationTheme {
        AppDetailsContent()
    }
}