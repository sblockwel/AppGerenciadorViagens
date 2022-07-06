package com.example.appgerenciadorviagens.views

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.viewModels.RegisterTravelViewModelFactory
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum
import java.text.DecimalFormat
import java.time.LocalDate

@Composable
fun travelView(navController: NavHostController, idUserLogged: Int) {
    val context = LocalContext.current
    val app = context.applicationContext as Application
    val travelModel:
            TravelViewModel = viewModel(
        factory = RegisterTravelViewModelFactory(app)
    )

    val travels by travelModel.getTravelsByUser(idUserLogged).observeAsState(listOf())
    LazyColumn(
        //verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(items = travels) { t ->
            val custoViagem by travelModel.sumSpentsByTravel(t.id).observeAsState(initial = 0.00)
            if (custoViagem > 0) {
                TravelCards(travelModel, )
            } else {
                TravelCards( travelModel)
            }
        }
    }
    
}

@Composable
fun TravelCards(travel: TravelViewModel) {
    val df = DecimalFormat("0.00")
    val context = LocalContext.current
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "clicou",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
    ) {
        Row() {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(text = "Destino ${travel.destiny}")
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(text = "Data de chegada: ${travel.arrivalDate}")
                Text(text = "Data de partida: ${travel.departureDate}")
            }
            Text(
                text = "R$ ${df.format(travel.budget)}", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            )
        }
    }
}
