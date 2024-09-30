# Libreta de Contactos

Este es un proyecto de una libreta de contactos desarrollada en Android utilizando Jetpack Compose y ViewModel.

## Características

- **Registrar Contactos**: Permite registrar nuevos contactos con información como nombre, apellido, teléfono, teléfono secundario, hobby y dirección.
- **Editar Contactos**: Permite editar la información de contactos existentes.
- **Eliminar Contactos**: Permite eliminar contactos de la lista.
- **Validación de Campos**: Valida que los campos obligatorios (nombre y teléfono) estén completos antes de registrar o actualizar un contacto.

## Estructura del Proyecto

- `ContactViewModel.kt`: Maneja la lógica de negocio y el estado de la lista de contactos.
- `ScreenA.kt`: Pantalla para registrar y editar contactos.
- `ScreenB.kt`: Pantalla para visualizar la lista de contactos y opciones para editar o eliminar contactos.

## Uso

1. **Registrar un nuevo contacto**:
    - Navega a la pantalla de registro de contactos.
    - Completa los campos obligatorios (nombre y teléfono) y cualquier otro campo opcional.
    - Haz clic en "Registrar" para guardar el contacto.

2. **Editar un contacto existente**:
    - En la lista de contactos, haz clic en el ícono de lápiz junto al contacto que deseas editar.
    - Modifica la información del contacto y haz clic en "Registrar" para guardar los cambios.

3. **Eliminar un contacto**:
    - En la lista de contactos, haz clic en el ícono de basura junto al contacto que deseas eliminar.
    - Confirma la eliminación.

## Elaborado por:

- Michael Alexander Corredor Castillo
