package com.example.appgerenciadorviagens.views

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.componente.datePicker
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.viewModels.RegisterTravelViewModelFactory
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum


@Composable
fun travelFormCompose(navController: NavHostController, id: Int?, idUserLogged: Int) {
    Log.i("TravelForm", "entrou ${id}")
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NavHomeManager.RegisterSpent.route) }) {
                Icon(Icons.Filled.Add, contentDescription = "Nova Despesa")
            }
        },
        isFloatingActionButtonDocked = true,
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(7.dp))
            travelForm(navController = navController, id, idUserLogged)
        }
    }
    //travelForm(navController = navController, id, idUserLogged)
}
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
                Text(text = "Novva iagem")
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.destiny,
                onValueChange = { travelFormModel.destiny = it },
                label = { Text("Destino") },
            )
            Row() {
                RadioButton(
                    selected = TravelTypeEnum.LEISURE == travelFormModel.type,
                    onClick = { travelFormModel.type = TravelTypeEnum.LEISURE },
                )
                Text(text = "Lazer")

                Spacer(modifier = Modifier.height(10.dp))

                RadioButton(
                    selected = TravelTypeEnum.BUSINESS == travelFormModel.type,
                    onClick = { travelFormModel.type = TravelTypeEnum.BUSINESS }
                )
                Text(text = "Trabalho")
            }
            travelFormModel.departureDate =
                datePicker("Data de partida", travelFormModel.departureDate)
            travelFormModel.arrivalDate = datePicker("Data de chegada", travelFormModel.arrivalDate)
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
                Button(onClick = {
                    navController.navigateUp()
                }
                ) {
                    Text(text = "Voltar")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (id != null && id > 0) {
                            travelFormModel.id = id
                            Toast
                                .makeText(
                                    context,
                                    "Viagem editada!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        } else {
                            Toast
                                .makeText(
                                    context,
                                    "Viagem cadastrada!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()

                        }
                        travelFormModel.register()
                        navController.navigate(NavHomeManager.Travels.route)
                    }
                ) {
                    Text(text = "Salvar")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    if (id != null) {
                        travelFormModel.deleteById(id)
                    }
                    navController.navigate(NavHomeManager.Travels.route)

                }
                ) {
                    Text(text = "Excluir")
                }
            }
        }

    }
}
