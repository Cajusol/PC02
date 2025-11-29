package com.mcajusol.pc02.presentation.auth.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mcajusol.pc02.data.model.MonedaModel


val mockMonedas = listOf(
    MonedaModel("USD", 3),
    MonedaModel("EUR",4),
    MonedaModel("GBP",5),
    MonedaModel("JPY",6),
    MonedaModel("PEN",7),
)

@Composable
fun HomeScreen(){


    var monto by remember {mutableStateOf("")}
    var expanded by remember { mutableStateOf(false) }

    var seleccion by remember { mutableStateOf(mockMonedas[0]) }


    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text("Conversor de Divisas", style = MaterialTheme.typography.titleLarge)

     OutlinedTextField(
        value = monto,
        onValueChange = {monto = it},
        label = {Text("Ingrese Monto")},
         modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
     )
        Spacer(modifier = Modifier.height(16.dp))
        Text("De", style = MaterialTheme.typography.titleLarge)

        Box(modifier = Modifier.padding(16.dp)) {
            Button(onClick = { expanded = true }) {
                Text(seleccion.moneda  )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                mockMonedas.forEach { moneda ->
                    DropdownMenuItem(
                        onClick = {
                            seleccion = moneda
                            expanded = false
                        },
                        text = { Text(moneda.moneda) }
                    )
                }
            }



        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("A", style = MaterialTheme.typography.titleLarge)

        Box(modifier = Modifier.padding(16.dp)) {
            Button(onClick = { expanded = true }) {
                Text(seleccion.moneda  )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                mockMonedas.forEach { moneda ->
                    DropdownMenuItem(
                        onClick = {
                            seleccion = moneda
                            expanded = false
                        },
                        text = { Text(moneda.moneda) }
                    )
                }
            }



        }
    }
}