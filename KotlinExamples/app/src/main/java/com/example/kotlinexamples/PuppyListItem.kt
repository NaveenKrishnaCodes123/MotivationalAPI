package com.example.kotlinexamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinexamples.model.Puppy
import com.example.kotlinprac.data.DataProvider

//@Preview(showBackground = true)
@Composable
fun PuppyListItem(puppy: Puppy,navigateToProfile: (Puppy) -> Unit) {

    /*Card(modifier=Modifier.padding(horizontal = 8.dp,vertical = 8.dp).fillMaxWidth()) {

    }*/

    Row (Modifier.clickable { navigateToProfile(puppy) },
        verticalAlignment = Alignment.CenterVertically){

        Image(painter = painterResource(puppy.puppyImageId),
            contentDescription = "",
            modifier = Modifier.padding(12.dp).size(84.dp).clip(shape = RoundedCornerShape(12.dp)))
         Column (){
             Text(text = puppy.title, fontSize = 16.sp,style = typography.bodyLarge)
             Text(text = puppy.description, fontSize = 10.sp,style = typography.bodyLarge)

         }

    }
}

@Preview
@Composable
fun PreviewPuppyItem() {
    val puppy = DataProvider.puppy
    PuppyListItem(puppy = puppy, navigateToProfile = {})
}