package com.example.snapchat

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignIn(name: String?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Log In", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome $name", /* Testing passed route argument "name" */
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Form2()
    }
}

@Composable
fun Form2() {
    var phoneNumber by remember { mutableStateOf("") }
    val blankTextFieldColor: TextFieldColors = TextFieldDefaults.colors(
        unfocusedIndicatorColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        focusedContainerColor = Color.Transparent
    )

    Column(horizontalAlignment = Alignment.Start) {
        Text("PHONE NUMBER", color = Color.Blue)
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = phoneNumber,
            onValueChange = {phoneNumber = it},
            colors = blankTextFieldColor,
            modifier = Modifier.border(
                color = Color.Black,
                width = 0.01.dp,
                shape = RoundedCornerShape(10.dp)
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("User email or username instead", color = Color.Blue)
        Spacer(modifier = Modifier.height(30.dp))
        Text("PASSWORD", color = Color.Blue)
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = phoneNumber,
            onValueChange = {phoneNumber = it},
            colors = blankTextFieldColor,
            modifier = Modifier.border(
                color = Color.Black,
                width = 0.5.dp,
                shape = RoundedCornerShape(10.dp)
            )
        )

    }

}



//@Preview(showBackground = true)
//@Composable
//fun SignInPreview() {
//    SignIn()
//}