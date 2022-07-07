package com.example.appgerenciadorviagens.views

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appgerenciadorviagens.R
import com.example.appgerenciadorviagens.componente.PasswordField
import com.example.appgerenciadorviagens.model.Person
import com.example.appgerenciadorviagens.navigation.NavManager
import com.example.appgerenciadorviagens.viewModels.PersonViewModel
import com.example.appgerenciadorviagens.viewModels.RegisterPersonViewModelFactory

@Composable
fun StateLogin(navController: NavHostController) {
    var isLogged by remember {
        mutableStateOf(false)
    }
    var loginUser by remember {
        mutableStateOf("")
    }
    var userId by remember {
        mutableStateOf(0)
    }
    if (isLogged) {
        navController.navigate("home/$loginUser/$userId")
    } else {
        loginView(
            onSuccess = {
                isLogged = true
                userId = it.id
                loginUser = it.name
            },
            navController = navController
        )
    }
}


@Composable
fun loginView(onSuccess: (Person) -> Unit, navController: NavHostController) {
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
                .padding(all = 25.dp)
                .fillMaxSize()
        ) {
            val context = LocalContext.current
            val app = context.applicationContext as Application
            val personModel:
                    PersonViewModel = viewModel(
                factory = RegisterPersonViewModelFactory(app)
            )

            Image(
                painter = painterResource(id = R.drawable.travelicon),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 8.dp)
            )
            if (personModel.username.isNotBlank()) {
                Text(
                    text = "Bem-Vindo(a), ${personModel.username}",
                    style = MaterialTheme.typography.h6
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(all = 25.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = personModel.username,
                    onValueChange = { personModel.username = it },
                    label = { Text("Usuário") },
                )
                PasswordField(
                    value = personModel.password,
                    onChange = { personModel.password = it },
                    label = "Senha",
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextButton(onClick = { navController.navigate(NavManager.ForgotPassword.route) {} }) {
                        Text(text = "Esqueci a senha")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = { navController.navigate(NavManager.Register.route) {} }) {
                        Text(text = "Cadastrar-se")
                    }
                }
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Button(
                    onClick = {
                        personModel.login(
                            onSucess = {
                                onSuccess(it)
                                Toast.makeText(context, "Logado!", Toast.LENGTH_SHORT).show()
                            },
                            onNotFound = {
                                Toast.makeText(context, "Login inválido!", Toast.LENGTH_SHORT)
                                    .show()
                            })
                    },
                ) {
                    Text(text = "Entrar")
                }
            }

        }
    }
}



