package com.gulehri.pakistan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import androidx.constraintlayout.compose.ConstraintLayout
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.StepSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RateUsDialog() {

    var rating: Float by remember { mutableFloatStateOf(0f) }

    var canShowDialog by remember {
        mutableStateOf(true)
    }


   if (canShowDialog){
       Dialog(onDismissRequest = { canShowDialog = false },
           properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {

           Card {
               ConstraintLayout(modifier = Modifier.padding(10.dp)) {

                   val (close, title, subtitle, description, ratingBar, thankYou) = createRefs()

                   Icon(imageVector = Icons.Default.Close, contentDescription = null, modifier = Modifier
                       .constrainAs(close) {
                           end.linkTo(parent.end)
                           top.linkTo(parent.top)
                       }
                       .padding(top = 5.dp, end = 5.dp)
                       .clickable { canShowDialog = false })



                   Text(text = "Rate Us", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold), modifier = Modifier
                       .constrainAs(title) {
                           top.linkTo(close.bottom)
                           start.linkTo(parent.start)
                       }
                       .padding(horizontal = 5.dp))



                   Text(text = "Your opinion matters to us!", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), modifier = Modifier
                       .constrainAs(subtitle) {
                           top.linkTo(title.bottom)
                           start.linkTo(title.start)
                       }
                       .padding(vertical = 5.dp, horizontal = 5.dp))


                   Text(text = "We work super hard to make application better for you, and would love to know", style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                       .constrainAs(description) {
                           top.linkTo(subtitle.bottom)
                           start.linkTo(subtitle.start)
                       }
                       .padding(horizontal = 5.dp).fillMaxWidth())


                   RatingBar(value = rating, onValueChange = { rating = it }, onRatingChanged = {

                   }, modifier = Modifier
                       .constrainAs(ratingBar) {
                           start.linkTo(parent.start)
                           end.linkTo(parent.end)
                           top.linkTo(description.bottom)
                       }
                       .padding(top = 15.dp), config = RatingBarConfig().stepSize(StepSize.HALF).size(40.dp).inactiveColor(Color.LightGray).activeColor(Color(0xFFFFA800)))


                   Text(text = "Thank you for rating us!", style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                       .constrainAs(thankYou) {
                           top.linkTo(ratingBar.bottom)
                           start.linkTo(parent.start)
                           end.linkTo(parent.end)
                       }
                       .padding(top = 15.dp))

               }
           }

       }
   }

}

