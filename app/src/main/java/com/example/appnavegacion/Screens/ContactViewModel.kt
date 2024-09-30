package com.example.appnavegacion

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

data class Contact(val name: String, val surname: String, val phone: String, val hobby: String, val secondPhone: String, val address: String)

class ContactViewModel : ViewModel() {
    val contacts = mutableStateListOf<Contact>()
    val message = mutableStateOf("")
    val showDialog = mutableStateOf(false)
    var editIndex = mutableStateOf(-1)

    fun addContact(name: String, surname: String, phone: String, hobby: String, secondPhone: String, address: String) {
        try {
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                if (editIndex.value == -1) {
                    contacts.add(Contact(name, surname, phone, hobby, secondPhone, address))
                    message.value = "Contacto registrado"
                } else {
                    contacts[editIndex.value] = Contact(name, surname, phone, hobby, secondPhone, address)
                    message.value = "Contacto actualizado"
                    editIndex.value = -1
                }
                showDialog.value = true
            } else {
                message.value = "Nombre y teléfono son obligatorios"
                showDialog.value = true
            }
        } catch (e: Exception) {
            message.value = "Error al registrar el contacto: ${e.message}"
            showDialog.value = true
        }
    }

    fun removeContact(index: Int) {
        try {
            contacts.removeAt(index)
            message.value = "Contacto eliminado"
            showDialog.value = true
        } catch (e: Exception) {
            message.value = "Error al eliminar el contacto: ${e.message}"
            showDialog.value = true
        }
    }

    fun setEditIndex(index: Int) {
        editIndex.value = index
    }
}
