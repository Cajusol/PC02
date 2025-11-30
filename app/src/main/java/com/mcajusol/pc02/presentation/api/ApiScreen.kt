package com.mcajusol.pc02.presentation.api

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.mcajusol.pc02.data.remote.api.ManoCartas


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApiScreen(viewModel: ApiViewModel = viewModel()){


    val manoCartas by viewModel.manoCartas.collectAsState()


    val selectedManoCarta by viewModel.selecteManoCarta.collectAsState()


    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()


    var expanded by remember {mutableStateOf(false)}
    val context = LocalContext.current

    Column (modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        Text("Blackjack"
            , style = MaterialTheme.typography.titleLarge)




        Spacer(modifier= Modifier.height(16.dp))

        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(selectedManoCarta?.deck_id ?: "Seleccionar Blackjack")
            }
            DropdownMenu(expanded = expanded
                , onDismissRequest = {expanded= false}){

                manoCartas.forEach { manoCarta ->
                    DropdownMenuItem(
                        text = {Text(manoCarta.deck_id)},
                        onClick = {
                            expanded = false
                            viewModel.onManoCartaSelected(manoCarta)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            if(isLoading){
                CircularProgressIndicator()
            }else if(errorMessage!=null){
                Text(errorMessage!!, color = MaterialTheme.colorScheme.error)
            } else {
                Text(errorMessage!!, color = MaterialTheme.colorScheme.error)
            }



        }

    }


}