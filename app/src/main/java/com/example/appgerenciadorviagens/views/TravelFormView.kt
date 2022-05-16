package com.example.appgerenciadorviagens.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.componente.PasswordField
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.viewModels.TravelViewModel


@Composable
fun travelForm(navController: NavHostController) {
    val travelFormModel: TravelViewModel = viewModel()
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(all = 15.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.destiny,
                onValueChange = { travelFormModel.destiny = it },
                label = { Text("Destino") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.type,
                onValueChange = { travelFormModel.type = it },
                label = { Text("Tipo") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.arrivalDate,
                onValueChange = { travelFormModel.arrivalDate = it },
                label = { Text("Data de chegada") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.departureDate,
                onValueChange = { travelFormModel.departureDate = it },
                label = { Text("Data de partida") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.budget,
                onValueChange = { travelFormModel.budget = it },
                label = { Text("Orçamento") },
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Row() {
                Button(
                    onClick = {
                              
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Salvar")
                }
                Button(onClick = { navController.navigateUp()}) {
                    Text(text = "Voltar")
                }
            }
        }

    }
}
