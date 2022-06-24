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
import com.example.appgerenciadorviagens.componente.LocalDateConverter
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
                selected = TravelTypeEnum.LAZER == travelFormModel.type,
                onClick = { travelFormModel.type = TravelTypeEnum.LAZER })
            RadioButton(
                selected = TravelTypeEnum.NEGOCIO == travelFormModel.type,
                onClick = { travelFormModel.type = TravelTypeEnum.NEGOCIO })
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.type.toString(),
                onValueChange = { travelFormModel.type = TravelTypeEnum.valueOf(it) },
                label = { Text("Tipo") },
            )
            /*OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.arrivalDate.toString(),
                onValueChange = {
                    try {
                        travelFormModel.arrivalDate = LocalDateConverter.dateToLong(it)
                    } catch (e: Exception) {
                        Log.e("app", "Erro de conversão!!")
                    }
                },
                label = { Text("Data de chegada") },
            )*/
            val mYear: Int
            val mMonth: Int
            val mDay: Int

            val mCalendar = Calendar.getInstance()

            mYear = mCalendar.get(Calendar.YEAR)
            mMonth = mCalendar.get(Calendar.MONTH)
            mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

            mCalendar.time = Date()

            val mDate = remember { mutableStateOf("") }

            val mDatePickerDialog = DatePickerDialog(
                context,
                { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                    mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
                }, mYear, mMonth, mDay
            )
            /*OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = travelFormModel.departureDate.toString(),
                onValueChange = {
                    try {
                        travelFormModel.departureDate = it
                    } catch (e: Exception) {
                        Log.e("app", "Erro de conversão!!")
                    }
                },
                label = { Text("Data de partida") },
            )*/
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
