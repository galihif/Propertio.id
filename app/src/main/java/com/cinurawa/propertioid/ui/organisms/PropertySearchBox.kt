package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.molecules.TipePropertiDropdown

@ExperimentalMaterialApi
@Composable
fun PropertySearchBox(
    modifier: Modifier = Modifier,
    options: List<String> = listOf("Option 1", "Option 2", "Option 3"),
    onOptionSelected: (String) -> Unit = {},
    selectedOption: String = "",
    keyword: String = "",
    onKeywordChanged: (String) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TipePropertiDropdown(
                options = options,
                selectedOption = selectedOption,
                onOptionSelected = { newOption ->
                    onOptionSelected(newOption)
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                value = keyword,
                label = { Text(text = "Cari properti disini...") },
                onValueChange = { newKeyword ->
                    onKeywordChanged(newKeyword)
                }
            )
            PrimaryButton(
                title = "Cari",
                icon = Icons.Default.Search,
                onClick = {}
            )
        }
    }
}