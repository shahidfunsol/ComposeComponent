package com.gulehri.pakistan.lanaguage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gulehri.pakistan.ui.theme.AppGreen

@Composable
fun LanguageScreen() {

    var selectedLanguage by remember {
        mutableStateOf(LANGUAGES_LIST.getOrNull(-1))
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "System Default", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(horizontal = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        SingleLanguageItem(language = LANGUAGES_LIST.first { it.languageName == "English" }, isSelected = selectedLanguage == null, modifier = Modifier.padding(horizontal = 10.dp)) {
            selectedLanguage = null
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "All Languages", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(horizontal = 10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 5.dp),
        ) {
            items(LANGUAGES_LIST.filter { it.languageName != "English" }) {
                SingleLanguageItem(language = it, isSelected = it == selectedLanguage) {
                    selectedLanguage = it
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }

}


@Composable
fun SingleLanguageItem(language: Language, isSelected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {

    var bgColor by remember {
        mutableStateOf(Color.Transparent)
    }

    var textColor by remember {
        mutableStateOf(Color.Black)
    }

    bgColor = if (isSelected)
        AppGreen
    else Color.Transparent

    textColor = if (isSelected)
        Color.White
    else Color.Black

    Row(
        modifier = modifier
            .background(color = bgColor, shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(50.dp)
            .clickable(role = Role.RadioButton, indication = null,
                interactionSource = remember { MutableInteractionSource() }) { onClick() },
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(10.dp))
        Text(text = language.flag, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = language.languageName, color = textColor, modifier = Modifier.weight(1f), style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.width(10.dp))
        RadioButton(
            enabled = false,
            selected = isSelected, onClick = {},
            colors = RadioButtonDefaults.colors(
                disabledSelectedColor = Color.White, disabledUnselectedColor = Color.LightGray

            )
        )
    }
}