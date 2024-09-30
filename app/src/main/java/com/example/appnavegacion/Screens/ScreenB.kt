package com.example.appnavegacion.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
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
import com.example.appnavegacion.Contact
import com.example.appnavegacion.ContactViewModel

@Composable
fun ScreenB(navController: NavController, contactViewModel: ContactViewModel) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de Contactos", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            itemsIndexed(contactViewModel.contacts) { index, contact ->
                ContactItem(contact, onDelete = { contactViewModel.removeContact(index) }, onEdit = {
                    contactViewModel.setEditIndex(index)
                    navController.navigate("screen_a")
                })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                contactViewModel.setEditIndex(-1) // Reset edit index for new contact
                navController.navigate("screen_a")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Pasar a registro de contactos")
        }
        if (contactViewModel.showDialog.value) {
            AlertDialog(
                onDismissRequest = { contactViewModel.showDialog.value = false },
                confirmButton = {
                    Button(onClick = { contactViewModel.showDialog.value = false }) {
                        Text("Aceptar")
                    }
                },
                text = { Text(contactViewModel.message.value) }
            )
        }
    }
}

@Composable
fun ContactItem(contact: Contact, onDelete: () -> Unit, onEdit: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "${contact.name} ${contact.surname}", style = TextStyle(fontSize = 18.sp))
            Text(text = "Tel: ${contact.phone}", style = TextStyle(fontSize = 16.sp))
            if (contact.hobby.isNotEmpty()) {
                Text(text = "Hobby: ${contact.hobby}", style = TextStyle(fontSize = 16.sp))
            }
            if (contact.secondPhone.isNotEmpty()) {
                Text(text = "Tel. Secundario: ${contact.secondPhone}", style = TextStyle(fontSize = 16.sp))
            }
            if (contact.address.isNotEmpty()) {
                Text(text = "Dirección: ${contact.address}", style = TextStyle(fontSize = 16.sp))
            }
        }
        Row {
            IconButton(onClick = onEdit) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Editar contacto"
                )
            }
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar contacto"
                )
            }
        }
    }
}