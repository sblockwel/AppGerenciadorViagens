package com.example.appgerenciadorviagens.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appgerenciadorviagens.R
import com.example.appgerenciadorviagens.componente.PasswordField
import com.example.appgerenciadorviagens.navigation.NavManager
import com.example.appgerenciadorviagens.viewModels.LoginViewModel

@Composable
fun loginView(navController: NavController) {

    val loginModel: LoginViewModel = viewModel()
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

            Image(
                painter = painterResource(id = R.drawable.travelicon),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 8.dp)
            )
            if (loginModel.username.isNotBlank()) {
                Text(
                    text = "Bem-Vindo(a), ${loginModel.username}",
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
                    value = loginModel.username,
                    onValueChange = { loginModel.username = it },
                    label = { Text("Usuário") },
                )
                PasswordField(
                    value = loginModel.password,
                    onChange = { loginModel.password = it },
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
                        if (loginModel.username.equals("admin") && loginModel.password.equals("admin")) {
                            //onSuccess()
                            Toast.makeText(context, "Logado!", Toast.LENGTH_SHORT).show()
                            navController.navigate(NavManager.Home.route) {}
                        } else {
                            Toast.makeText(context, "Login inválido!", Toast.LENGTH_SHORT)
                                .show()

                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Entrar")
                }

            }

        }
    }

}

