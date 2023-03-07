package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@ExperimentalMaterialApi
@Composable
fun TipePropertiDropdown(
    options: List<String>,
    selectedOption: String = "",
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        // text field
        OutlinedTextField(
            value = if (selectedOption == "") "" else selectedOption,
            onValueChange = {},
            placeholder = { Text(text = "Pilih Tipe Properti") },
            readOnly = true,
            label = { Text(text = "Pilih Tipe Properti") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
        )
        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { selected ->
                // menu item
                DropdownMenuItem(onClick = {
                    onOptionSelected(selected)
                    expanded = false
                }) {
                    Text(text = selected)
                }
            }
        }
    }
}