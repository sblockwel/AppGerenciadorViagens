package com.example.appgerenciadorviagens.views

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enum.TravelTypeEnum
import java.text.DecimalFormat

@Composable
fun travelView(navController: NavController) {

   var t1: TravelViewModel = viewModel()
    t1.id = 1
    t1.budget = 10000.00
    t1.destiny = "Dubai"
    t1.arrivalDate = "20/12/2023"
    t1.departureDate = "10/01/2024"
    t1.type = TravelTypeEnum.LAZER
    t1.user= "sabrina"

    var t2: TravelViewModel = viewModel()
    t2.id = 1
    t2.budget = 100.00
    t2.destiny = "Holanda"
    t2.arrivalDate = "05/08/2022"
    t2.departureDate = "12/09/2022"
    t2.type = TravelTypeEnum.NEGOCIO
    t2.user= "sabrina"

    val travels = listOf(
        t1,
        t2
    )

    LazyColumn() {
        items(items = travels) { t ->
            TravelCards(t)
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
