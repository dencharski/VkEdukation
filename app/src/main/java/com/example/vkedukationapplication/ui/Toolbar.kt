package com.example.vkedukationapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkedukationapplication.R
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

@Composable
internal fun Toolbar(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.baseline_arrow_back_24),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
        IconButton(onClick = onShareClick) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.outline_share_24),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEdukationApplicationTheme() {
        Toolbar(
            onBackClick = {},
            onShareClick = {},
        )
    }
}