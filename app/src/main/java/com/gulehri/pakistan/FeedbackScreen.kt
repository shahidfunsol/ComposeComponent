package com.gulehri.pakistan;

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gulehri.pakistan.ui.theme.AppGreen

/*
 * Created by Shahid Iqbal on 8/16/2023.
 */
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun FeedbackScreen() {

    val itemsList = listOf(
        "Crash", "App not responding", "Ads", "Functions Disabled", "Premium not working",
        "Don't Know how to use", "Others"
    )


    val selectedItems = remember {
        mutableStateListOf(itemsList.getOrNull(-1))
    }

    var details by remember {
        mutableStateOf("")
    }

    Column {
        TopAppBar(title = { Text(text = "Feedback") }, navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack, contentDescription = null, modifier = Modifier.padding(horizontal = 5.dp)
            )
        }, modifier = Modifier.shadow(elevation = 2.dp))

        Column(
            Modifier
                .weight(1f, fill = false)
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "What type of problem are you facing?", fontSize = 14.sp, fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsList.forEach {
                    SingleChip(
                        label = it, selected = selectedItems.contains(it), chipsColors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = AppGreen,
                            selectedLabelColor = Color.White,
                            containerColor = Color.White
                        )
                    ) {
                        if (selectedItems.contains(it)) {
                            selectedItems.remove(it)
                        } else {
                            selectedItems.add(it)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Details", fontSize = 14.sp, fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = details, onValueChange = { details = it }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    disabledIndicatorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                ), modifier = Modifier
                    .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                    .shadow(2.dp, shape = RoundedCornerShape(6.dp))
                    .fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                minLines = 12,
                placeholder = {
                    Text(
                        text = "Share your thoughts",
                        style = MaterialTheme.typography.bodySmall.copy(Color.LightGray)
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )

            Spacer(modifier = Modifier.height(20.dp))


            Button(
                onClick = { },
                Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                    containerColor = AppGreen
                ), shape = RoundedCornerShape(5.dp)
            ) {

                Text(
                    text = "Submit", fontWeight = FontWeight.Bold, modifier = Modifier
                        .padding(5.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChip(selected: Boolean, label: String, chipsColors: SelectableChipColors, onClick: () -> Unit) {
    FilterChip(
        selected = selected, onClick = onClick, border = FilterChipDefaults.filterChipBorder(
            borderColor = Color.Transparent
        ), label = {
            Text(text = label, Modifier.background(Color.Transparent), fontSize = 14.sp)
        }, colors = chipsColors, elevation = FilterChipDefaults.filterChipElevation(
            elevation = 3.dp, focusedElevation = 3.dp
        ), shape = RoundedCornerShape(4.dp)


    )

}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen(
    @StringRes chipListLabel: Int,
    @StringRes chipsTextList: List<Int>,
    @StringRes textBoxLabel: Int,
    @StringRes textBoxPlaceHolder: Int,
    @StringRes buttonText: Int,
    colors: FeedbackColors,
    modifier: Modifier,
    onSubmit: (List<Int?>, feedbackText: String) -> Unit
) {

    val selectedItems = remember {
        mutableStateListOf(chipsTextList.getOrNull(-1))
    }


    var details by remember {
        mutableStateOf("")
    }


    Column(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = chipListLabel), fontSize = 14.sp, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            chipsTextList.forEach {
                val text = stringResource(id = it)
                SingleChip(label = text, selected = selectedItems.contains(it), chipsColors = colors.chipsColor) {
                    if (selectedItems.contains(it))
                        selectedItems.remove(it)
                    else
                        selectedItems.add(it)

                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = textBoxLabel), fontSize = 14.sp, fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = details, onValueChange = { details = it }, colors = colors.textBoxColors, modifier = Modifier
                .background(Color.Transparent, shape = RoundedCornerShape(6.dp))
                .shadow(2.dp, shape = RoundedCornerShape(6.dp))
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            minLines = 12,
            placeholder = {
                Text(
                    text = stringResource(id = textBoxPlaceHolder),
                    style = MaterialTheme.typography.bodySmall.copy(color = colorResource(id = colors.textBoxPlaceholderColor))
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = { onSubmit(selectedItems.map { it }, details) },
            Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = colors.buttonColor)
            ), shape = RoundedCornerShape(5.dp)
        ) {

            Text(
                text = stringResource(id = buttonText), fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(5.dp)
            )
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
}

