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
import com.example.appgerenciadorviagens.viewModels.SpentViewModel

@Composable
fun SpentForm(navController: NavHostController, idTravel: Int?, idSpent: Int) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(NavHomeManager.RegisterSpent.route) }) {
                Icon(Icons.Filled.Add, contentDescription = "Nova Despesa")
            }
        },
        isFloatingActionButtonDocked = true,
    ) {}

    val context = LocalContext.current
    val app = context.applicationContext as Application

    val spentViewModel: SpentViewModel = viewModel(
        factory = RegisterTravelViewModelFactory(app)
    )

    if (idSpent != null && idSpent > 0) {
        spentViewModel.id = idSpent
        spentViewModel.findById(idSpent)
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
            /*ExposedDropdownMenuBox(expanded = exp, onExpandedChange = { exp = !exp }) {
                TextField(
                    value = selectedOption,
                    onValueChange = { selectedOption = it },
                    label = { Text("Selecione ou digite a categoria") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = exp)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )
                ExposedDropdownMenu(expanded = exp, onDismissRequest = { exp = false }) {
                    categorias.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOption = option.nome
                                selectedCategoriaID = option.id
                                exp = false
                            }
                        ) {
                            Text(text = option.nome)
                        }
                    }
                }
            }*/
            if (idSpent != null && idSpent > 0) {
                Text(text = "Editar despesa")
            } else {
                Text(text = "Nova Despesa")
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = spentViewModel.description,
                onValueChange = { spentViewModel.description = it },
                label = { Text("Descrição") },
            )
            spentViewModel.date = datePicker("Data", spentViewModel.date)
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = spentViewModel.value.toString(),
                onValueChange = {
                    try {
                        spentViewModel.value = it.toDoubleOrNull()!!
                    } catch (e: Exception) {
                        Log.e("app", "Erro de conversão!!")
                    }
                },
                label = { Text("Valor") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Row() {
                Button(onClick = {
                    navController.navigateUp() }
                ) {
                    Text(text = "Voltar")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (idSpent != null && idSpent > 0) {
                            spentViewModel.id = idSpent
                            Toast
                                .makeText(
                                    context,
                                    "Despesa editada!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        } else {
                            Toast
                                .makeText(
                                    context,
                                    "Despesa cadastrada!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()

                        }
                        spentViewModel.register()
                        navController.navigate(NavHomeManager.Spent.route)
                    }
                ) {
                    Text(text = "Salvar")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                }
                ) {
                    if (idSpent != null) {
                        spentViewModel.deleteById(idSpent)
                    }
                    navController.navigate(NavHomeManager.Travels.route)
                    Text(text = "Excluir")
                }
            }
        }

    }
}