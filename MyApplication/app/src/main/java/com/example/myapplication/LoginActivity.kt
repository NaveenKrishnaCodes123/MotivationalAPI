@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplication.ui.theme.MyApplicationTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Greeting()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting() {
    var userid by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val maxLength = 8
    Column (modifier = Modifier.fillMaxWidth().fillMaxHeight().absolutePadding(0.dp,0.dp,0.dp,150.dp),
        verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Welcome", color = Color.Red)
                Text(text = "Sign in to contine",color = Color.Blue)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.rbl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(104.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
        }

        OutlinedTextField(
            value = userid,
            onValueChange = {
                newText ->
                if (newText.length <= maxLength) {
                    userid = newText
                }
            },
            label = { Text("Enter your UserID") },
            placeholder = { Text("Type here...") },
            singleLine = true,
            shape = MaterialTheme.shapes.small, // Rounded corners for TextField
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp,4.dp,18.dp,4.dp)
              /*  .height(56.dp) // Set a height for the TextField*/
                .clip(MaterialTheme.shapes.small),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done // Defines the action on the keyboard (e.g., "Done")
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle "Done" action */ }
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = {  newText ->
                if (newText.length <= 15) {
                    password = newText
                } /*password = it*/ },
            label = { Text("Enter your Password") },
            placeholder = { Text("Type here...") },
            singleLine = true,
            shape = MaterialTheme.shapes.small, // Rounded corners for TextField
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp,4.dp,18.dp,4.dp)
                /*.height(56.dp) */// Set a height for the TextField*/
                .clip(MaterialTheme.shapes.small),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // Defines the action on the keyboard (e.g., "Done")
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle "Done" action */ }
            )
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
                .padding(18.dp,4.dp,18.dp,4.dp)
        ) {
            // The text field that displays the selected option
            OutlinedTextField(
                value = selectedOption,
                onValueChange = { },
                readOnly = true, // Make the TextField read-only, as it's used for displaying the dropdown option
                label = { Text("Select Role") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor() // Required to make the dropdown appear at the right place
            )

            // The actual dropdown menu that displays the options
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption = option
                            expanded = false
                        }
                    )
                }
            }
        }

        Button(
            onClick = {
                if(userid==""){
                    Toast.makeText(context, "Please Enter UserId", Toast.LENGTH_SHORT).show()
                }else if(password==""){
                    Toast.makeText(context, "Please Enter Password", Toast.LENGTH_SHORT).show()
                }else if(selectedOption==""){
                    Toast.makeText(context, "Please Select DropDown", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(18.dp,4.dp,18.dp,4.dp)
                .fillMaxWidth()
                .height(46.dp), // Set height for the button
            shape = RoundedCornerShape(16.dp), // Set custom rounded corners
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red, // Set custom background color
                contentColor = Color.White // Set custom text color
            ),
            //elevation = ButtonDefaults.elevation(8.dp) // Set button elevation (shadow effect)
        ) {
            Text(text = "Login")
        }
    }
}