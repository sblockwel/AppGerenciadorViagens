package com.example.appgerenciadorviagens.views

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.BeachAccess
import androidx.compose.material.icons.rounded.Surfing
import androidx.compose.material.icons.rounded.Work
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.appgerenciadorviagens.model.Travel
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.viewModels.RegisterTravelViewModelFactory
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum
import java.text.DecimalFormat

@Composable
fun travelListView(navController: NavHostController, idUserLogged: Int) {
    val context = LocalContext.current
    val app = context.applicationContext as Application
    val travelModel:
            TravelViewModel = viewModel(
        factory = RegisterTravelViewModelFactory(app)
    )

    val travels by travelModel.getTravelsByUser(idUserLogged).observeAsState(listOf())
    LazyColumn() {
        items(items = travels) { t ->
            val custoViagem by travelModel.sumSpentsByTravel(t.id).observeAsState(initial = 0.00)
            if (custoViagem > 0) {
                TravelCards(navController, t, custoViagem, idUserLogged)
            } else {
                TravelCards(navController, t, 0.00, idUserLogged)
            }
        }
    }
}

@Composable
fun travelCompose(navController: NavHostController, idUserLogged: Int) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavHomeManager.RegisterTravel.route)
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Nova Viagem")
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
            travelListView(navController = navController, idUserLogged)
        }

    }

}

@Composable
fun TravelCards(
    navController: NavHostController,
    travel: Travel,
    budgetB: Double,
    idUserLogged: Int
) {
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
                navController.navigate( "registerTravel/" + travel.id + "/" + idUserLogged)
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.padding(5.dp))

            if (travel.type == TravelTypeEnum.LEISURE) {
                Icon(
                    imageVector = Icons.Rounded.BeachAccess,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(vertical = 5.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Rounded.Work,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(vertical = 5.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Text(text = "Destino: ${travel.destiny}")
                Spacer(modifier = Modifier.padding(3.dp))
                Text(text = "Data de chegada: ${travel.arrivalDate}")
                Text(text = "Data de partida: ${travel.departureDate}")
                Spacer(modifier = Modifier.padding(3.dp))
                if (budgetB > 0) {
                    var cor by remember {
                        mutableStateOf(Color.Green)
                    }
                    if (budgetB > travel.budget) {
                        cor = Color.Red
                    }
                    Text(
                        text = "R$ ${df.format(travel.budget)} - R$ ${df.format(budgetB)}",
                        modifier = Modifier
                            .padding(16.dp),
                        color = cor
                    )
                } else {
                    Text(
                        text = "R$ ${df.format(travel.budget)} — R$ 0,00",
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Green
                    )
                }
            }
        }
    }
}


fun NavGraphBuilder.formTravelGrap(navController: NavHostController, idUserLogged: Int) {
    navigation(startDestination = "principal", route = "travel") {
        composable("principal") { travelCompose(navController, idUserLogged) }
        composable("registerTravel/{travelId}/{UserId}",
            arguments = listOf(
                navArgument("travelId") {
                    type = NavType.IntType
                },
                navArgument("UserId") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("travelId")
            val idUser = it.arguments?.getInt("UserId")
            if (idUser != null) {
                travelFormCompose(navController, id, idUser)
            }
        }
    }
}
