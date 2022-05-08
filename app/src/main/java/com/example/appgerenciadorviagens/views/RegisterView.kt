package com.example.appgerenciadorviagens.views

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
import com.example.appgerenciadorviagens.viewModels.PessoaViewModel


@Composable
fun registerView(navController: NavHostController) {
    val pessoaModel: PessoaViewModel = viewModel()
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

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = pessoaModel.username,
                onValueChange = { pessoaModel.username = it },
                label = { Text("Usuário") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = pessoaModel.email,
                onValueChange = { pessoaModel.email = it },
                label = { Text("E-mail") },
            )
            PasswordField(
                value = pessoaModel.password,
                onChange = { pessoaModel.password = it },
                label = "Senha"
            )
            PasswordField(
                value = pessoaModel.confirmPassword,
                onChange = { pessoaModel.confirmPassword = it },
                label = "Confirmar senha"
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(
                onClick = {
                    pessoaModel.register()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Entrar")
            }
            Button(onClick = { navController.navigateUp() }) {
                Text(text = "Voltar")
            }
        }
    }
}
