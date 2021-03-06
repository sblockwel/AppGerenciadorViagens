package com.example.appgerenciadorviagens.views

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.componente.PasswordField
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.navigation.NavManager
import com.example.appgerenciadorviagens.viewModels.PersonViewModel
import com.example.appgerenciadorviagens.viewModels.RegisterPersonViewModelFactory


@Composable
fun registerView(navController: NavHostController) {
    val context = LocalContext.current
    val app = context.applicationContext as Application

    val personModel: PersonViewModel = viewModel(
        factory = RegisterPersonViewModelFactory(app)
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
                value = personModel.name,
                onValueChange = { personModel.name = it },
                label = { Text("Nome") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = personModel.username,
                onValueChange = { personModel.username = it },
                label = { Text("Usu??rio") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = personModel.email,
                onValueChange = { personModel.email = it },
                label = { Text("E-mail") },
            )
            PasswordField(
                value = personModel.password,
                onChange = { personModel.password = it },
                label = "Senha",
                modifier = Modifier.fillMaxWidth()
            )
            PasswordField(
                value = personModel.confirmPassword,
                onChange = { personModel.confirmPassword = it },
                label = "Confirmar senha",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Row() {
                Button(
                    onClick = {
                        personModel.register()
                        navController.navigate(NavManager.Login.route) {  }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Salvar")
                }
                Button(onClick = { navController.navigateUp()}) {
                    Text(text = "Voltar")
                }
            }
        }

    }
}
