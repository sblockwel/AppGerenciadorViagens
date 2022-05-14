package com.example.appgerenciadorviagens.views

import android.widget.Toast
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
import androidx.navigation.NavController
import com.example.appgerenciadorviagens.viewModels.ForgotPasswordViewModel

@Composable
fun forgotPasswordView(navController: NavController) {
    val forgotModel: ForgotPasswordViewModel = viewModel()

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
                value = forgotModel.email,
                onValueChange = { forgotModel.email = it },
                label = { Text("E-mail") },
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(
                onClick = {
                    forgotModel.recoverPassword()
                    Toast.makeText(context, "Enviado!", Toast.LENGTH_LONG).show();
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Enviar")

            }
        }
    }
}