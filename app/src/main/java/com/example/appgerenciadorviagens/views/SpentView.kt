package com.example.appgerenciadorviagens.views

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.navigation
import com.example.appgerenciadorviagens.model.Spent
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.viewModels.RegisterSpentViewModelFactory
import java.text.DecimalFormat

/*
@Composable
fun SpentCompose(navController: NavHostController, idTravel: Int, destinyTravel: String) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("registerSpent/$idTravel") }) {
                Icon(Icons.Filled.Add, contentDescription = "Nova despesa")
            }
        },
        isFloatingActionButtonDocked = true,
    ) {
        Column(
        ) {
            Text(
                text = "Despesas da viagem de $destinyTravel",
                style = TextStyle(fontSize = 30.sp, fontFamily = FontFamily.Cursive)
            )
            Spacer(modifier = Modifier.padding(7.dp))
            spentListView(navController = navController, idTravel)
        }

    }
}

fun NavGraphBuilder.formDespesaGrap(navController: NavHostController, idUserLogged: Int) {
    navigation(startDestination = "principal", route = "despesas") {
        composable("principal") { travelCompose(navController, idUserLogged) }
        composable("registerSpent/{spentId}",
            arguments = listOf(
                navArgument("spentId") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("spentId")
            SpentForm(navController, id, 0)
        }
    }
}

@Composable
fun spentListView(navController: NavHostController, idTravel: Int) {
    val context = LocalContext.current
    val app = context.applicationContext as Application
    val spentModel:
            SpentViewModel = viewModel(
        factory = RegisterSpentViewModelFactory(app)
    )

    val spents by spentModel.allSpentsByTravel(idTravel).observeAsState(listOf())
    LazyColumn() {
        items(items = spents) { s ->
            spentCards(navController, s, spentModel)
        }
    }

}

@Composable
fun spentCards(
    navController: NavHostController,
    spent: Spent,
    spentModel: SpentViewModel
) {
    val df = DecimalFormat("0.00")
    val context = LocalContext.current

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                navController.navigate(NavHomeManager.RegisterSpent.route + "/" + spent.travelId + "/" + spent.id)
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Text(text = "Categoria: ${spent.categoryId}")
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = "Local: " + spent.local,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = "Data: " + spent.date,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = "Descrição: " + spent.description,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.padding(5.dp))
            }
            Text(
                text = "R$ ${df.format(spent.value)}",
            )
        }
    }
}
*/
