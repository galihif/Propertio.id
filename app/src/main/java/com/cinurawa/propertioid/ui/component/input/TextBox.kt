import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun SelectDropdown(
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