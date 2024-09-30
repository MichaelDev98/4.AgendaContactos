package com.example.appnavegacion.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnavegacion.ContactViewModel
import java.util.*

@Composable
fun ScreenA(navController: NavController, contactViewModel: ContactViewModel) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var secondPhone by remember { mutableStateOf("") }
    var hobby by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var year by remember { mutableStateOf(Calendar.getInstance().get(Calendar.YEAR)) }
    var month by remember { mutableStateOf(Calendar.getInstance().get(Calendar.MONTH) + 1) }
    var day by remember { mutableStateOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) }

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB))
    )

    LaunchedEffect(contactViewModel.editIndex.value) {
        if (contactViewModel.editIndex.value != -1) {
            val contact = contactViewModel.contacts[contactViewModel.editIndex.value]
            name = contact.name
            surname = contact.surname
            phone = contact.phone
            secondPhone = contact.secondPhone
            hobby = contact.hobby
            address = contact.address
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Registro de Contacto", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
        )
        Text(text = "Obligatorio", style = TextStyle(color = Color.Red))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = surname,
            onValueChange = { surname = it },
            label = { Text("Apellido") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
        )
        Text(text = "Opcional", style = TextStyle(color = Color.Gray))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
        )
        Text(text = "Obligatorio", style = TextStyle(color = Color.Red))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = secondPhone,
            onValueChange = { secondPhone = it },
            label = { Text("Teléfono Secundario") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
        )
        Text(text = "Opcional", style = TextStyle(color = Color.Gray))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = hobby,
            onValueChange = { hobby = it },
            label = { Text("Hobby") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
        )
        Text(text = "Opcional", style = TextStyle(color = Color.Gray))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Dirección") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
        )
        Text(text = "Opcional", style = TextStyle(color = Color.Gray))
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            try {
                contactViewModel.addContact(name, surname, phone, hobby, secondPhone, address)
                navController.navigate("screen_b")
            } catch (e: Exception) {
                contactViewModel.message.value = "Error al registrar el contacto: ${e.message}"
                contactViewModel.showDialog.value = true
            }
        }) {
            Text(text = "Registrar")
        }
    }
}
