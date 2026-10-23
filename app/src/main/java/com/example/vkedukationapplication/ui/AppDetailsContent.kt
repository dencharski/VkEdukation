package com.example.vkedukationapplication.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkedukationapplication.domain.AppDetails
import com.example.vkedukationapplication.domain.Category
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
                AppDetails(
                    id = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
                    name = "Гильдия Героев: Экшен ММО РПГ",
                    developer = "VK Play",
                    category = Category.GAME,
                    ageRating = 12,
                    size = 223.7f,
                    screenshotUrlList = listOf(
                        "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                        "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                        "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
                        "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
                    ),
                    iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                    description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
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