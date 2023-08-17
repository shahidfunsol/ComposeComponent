package com.gulehri.pakistan

import androidx.annotation.ColorRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.TextFieldColors

@OptIn(ExperimentalMaterial3Api::class)
data class FeedbackColors(
    @ColorRes val chipListLabelColor: Int,
    val chipsColor: SelectableChipColors,
    @ColorRes val textBoxLabelColor: Int,
    @ColorRes val textBoxPlaceholderColor: Int,
    val textBoxColors: TextFieldColors,
    @ColorRes val buttonTextColor: Int,
    @ColorRes val buttonColor: Int,
)

