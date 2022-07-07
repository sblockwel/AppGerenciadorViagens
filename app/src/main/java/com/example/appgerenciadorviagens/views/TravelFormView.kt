package com.example.appgerenciadorviagens.views

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.componente.datePicker
import com.example.appgerenciadorviagens.viewModels.RegisterTravelViewModelFactory
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum


@Composable
fun travelForm(navController: NavHostController, id: Int?, idUserLogged: Int) {
    val context = LocalContext.current
    val app = context.applicationContext as Application

    val travelFormModel: TravelViewModel = viewModel(
        factory = RegisterTravelViewModelFactory(app)
    )

    if (id != null && id > 0) {
        travelFormModel.id = id
        travelFormModel.findById(id)
    }
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
            if (id != null && id > 0) {
                Text(text = "Editar viagem")
            } else {
                Text(text = "Nova viagem")
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.destiny,
                onValueChange = { travelFormModel.destiny = it },
                label = { Text("Destino") },
            )
            RadioButton(
                selected = TravelTypeEnum.LEISURE == travelFormModel.type,
                onClick = { travelFormModel.type = TravelTypeEnum.LEISURE })
            RadioButton(
                selected = TravelTypeEnum.BUSINESS == travelFormModel.type,
                onClick = { travelFormModel.type = TravelTypeEnum.BUSINESS })
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.type.toString(),
                onValueChange = { travelFormModel.type = TravelTypeEnum.valueOf(it) },
                label = { Text("Tipo") },
            )
            travelFormModel.departureDate = datePicker("Data de partida", travelFormModel.departureDate)
            travelFormModel.arrivalDate = datePicker("Data de chegada", travelFormModel.arrivalDate )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.budget.toString(),
                onValueChange = {
                    try {
                        travelFormModel.budget = it.toDoubleOrNull()!!
                    } catch (e: Exception) {
                        Log.e("app", "Erro de conversão!!")
                    }
                },
                label = { Text("Orçamento") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            travelFormModel.user = idUserLogged
            Row() {
                Button(
                    onClick = {
                        if (id != null && id > 0) {
                            Toast
                                .makeText(
                                    context,
                                    "Viagem editada com sucesso!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        } else {
                            Toast
                                .makeText(
                                    context,
                                    "Viagem cadastrada com sucesso!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                        travelFormModel.register()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Salvar")
                }
                Button(onClick = { navController.navigateUp() }) {
                    Text(text = "Voltar")
                }
            }
        }

    }
}
