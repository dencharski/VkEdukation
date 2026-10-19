package com.example.vkedukationapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.vkedukationapplication.R
import com.example.vkedukationapplication.domain.SimilarApp
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

@Composable
fun SimilarApps(
    apps: List<SimilarApp>,
    onItemClick: (SimilarApp) -> Unit,
    modifier: Modifier = Modifier,

    ) {
    val pagerState = rememberPagerState { 3 }
    Column(modifier) {
        Text(
            text = stringResource(R.string.app_showcase),
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(Modifier.height(4.dp))

        HorizontalPager(state = pagerState)
        { page ->
            Row() {
                for (i in 0 until 3) {
                    SimilarAppItem(app = apps[page * 3 + i], onItemClick = {

                    })
                }
            }

        }

    }
}

@Composable
private fun SimilarAppItem(
    app: SimilarApp,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(128.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = app.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
        Text(text = app.name, maxLines = 2, overflow = TextOverflow.Ellipsis)
        Button(
            onClick = onItemClick,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.app_details_download),
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    VkEdukationApplicationTheme() {
        SimilarApps(
            apps = List(9) { index ->
                SimilarApp(
                    id = "similar-app-$index",
                    name = "$index Гильдия Героев: Экшен ММО РПГ: $index",
                    iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                )
            },
            onItemClick = {},
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }

}