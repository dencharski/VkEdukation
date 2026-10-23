package com.example.vkedukationapplication.ui

import androidx.compose.runtime.Immutable
import com.example.vkedukationapplication.domain.AppDetails

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}