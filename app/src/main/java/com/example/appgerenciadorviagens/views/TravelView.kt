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
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum
import java.text.DecimalFormat
import java.time.LocalDate

@Composable
fun travelView(navController: NavHostController) {

   var t1: TravelViewModel = viewModel()
    t1.id = 1
    t1.budget = 10000.00
    t1.destiny = "Dubai"
    t1.arrivalDate = LocalDate.now()
    t1.departureDate = LocalDate.now()
    t1.type = TravelTypeEnum.LEISURE
    t1.user= 1

    var t2: TravelViewModel = viewModel()
    t2.id = 1
    t2.budget = 100.00
    t2.destiny = "Holanda"
    t2.arrivalDate = LocalDate.now()
    t2.departureDate = LocalDate.now()
    t2.type = TravelTypeEnum.BUSINESS
    t2.user= 1

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
