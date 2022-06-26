package com.example.appgerenciadorviagens.views

import android.app.Application
import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.componente.datePicker
import com.example.appgerenciadorviagens.utils.LocalDateConverter
import com.example.appgerenciadorviagens.viewModels.RegisterTravelViewModelFactory
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enum.TravelTypeEnum
import java.util.*


@Composable
fun travelForm(navController: NavHostController) {
    val context = LocalContext.current
    val app = context.applicationContext as Application

    val travelFormModel: TravelViewModel = viewModel(
        factory = RegisterTravelViewModelFactory(app)
    )

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
                Button(onClick = { navController.navigateUp() }) {
                    Text(text = "Voltar")
                }
            }
        }

    }
}
