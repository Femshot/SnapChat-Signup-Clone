package com.example.snapchat

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignUp(navigate: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TopHeader(navigate)
        Spacer(modifier = Modifier.height(20.dp))
        SignUpLogo()
        Form()
    }
}

@Composable
fun TopHeader(navigate: (String) -> Unit) {
    Row(modifier = Modifier
        .padding(top = 40.dp)
        .height(40.dp)
        .fillMaxWidth()
        .background(Color(0xFFEEEEEE)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Text("Already have a Snapchat account?",
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = { navigate("second/") },
            contentPadding = PaddingValues(),
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Black
            ),
            modifier = Modifier
                .height(25.dp)
                .width(70.dp)) {
            Text("Log In", fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun SignUpLogo() {
    val header = painterResource(R.drawable.snaplogo)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = header,
            contentDescription = "snaplogo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
        )
        Text("Sign Up",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp)
    }
}

@Composable
fun Form() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    FormField(firstName, "First Name") { firstName = it }
    FormField(lastName, "last Name") { lastName = it }
    FormField(username, "Username") { username = it }
    FormField(password, "Password") { password = it }
    FormField(email, "Email") { email = it }
    BirthdayFormField(month,
        {month = it},
        day, { day = it },
        year,
        { year = it}
    )
    Spacer(modifier = Modifier.height(10.dp))
    SignUpButton(checkFormData(
        firstName,
        lastName,
        username,
        password,
        email,
        month,
        day,
        year
    ))
}

fun checkFormData(vararg fields: String): Boolean {
    for (field in fields) {
        if (field == "") return false
    }
    return true
}


@Composable
fun FormField(
    name: String,
    label: String,
    onNameChange: (String) -> Unit
) {
    Column(modifier = Modifier
        .padding(horizontal = 30.dp, vertical = 8.dp)) {
        Text(label,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = name,
            onValueChange = { onNameChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = formColor()
        )
    }
}

@Composable
fun BirthdayFormField(
    month: String,
    onMonthChange: (String) -> Unit,
    day: String,
    onDayChange: (String) -> Unit,
    year: String,
    onYearChange: (String) -> Unit,
) {
    Column(modifier = Modifier
        .padding(horizontal = 30.dp, vertical = 8.dp)
    ) {
        Text("Birthday",
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
        Row {
            TextField(
                value = month,
                onValueChange = { onMonthChange(it) },
                modifier = Modifier
                    .weight(2f)
                    .height(50.dp),
                colors = formColor()
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = day,
                onValueChange = { onDayChange(it) },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = formColor()
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = year,
                onValueChange = { onYearChange(it) },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = formColor()
            )
        }
    }
}

@Composable
fun formColor(): TextFieldColors {
    return TextFieldDefaults.colors(
        focusedContainerColor = Color(0xFFEEEEEE),
        unfocusedContainerColor = Color(0xFFEEEEEE),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )
}

@Composable
fun SignUpButton(validated: Boolean) {
    Button(onClick = {
        if (validated) {
            Log.d("SignUp", "SignUpButton: Succesfull")
        } else {
            Log.d("SignUp", "SignUpButton: Unsuccesfull")
        }
    },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Black)) {
        Text("Sign up & Accept")
    }
}
