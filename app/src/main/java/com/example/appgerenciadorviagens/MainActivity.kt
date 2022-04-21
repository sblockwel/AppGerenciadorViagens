package com.example.appgerenciadorviagens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appgerenciadorviagens.ui.theme.AppGerenciadorViagensTheme
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGerenciadorViagensTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var userState by remember {
        mutableStateOf("")
    }
    var isLogged by remember {
        mutableStateOf(false)
    }
    if (isLogged) {
        Welcome(name = userState)
    } else {
        Login(userState,
            onUserChange ={
                userState = it
            },
            onSuccess = {
            isLogged = true
        })
    }

}

@Composable
fun Welcome(name: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem-Vindo(a), ${name}",
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun Login(user: String, onUserChange: (String) -> Unit, onSuccess: () -> Unit) {
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
            var passwordState by remember {
                mutableStateOf("")
            }

            val context = LocalContext.current

            Image(
                painter = painterResource(id = R.drawable.travelicon),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 8.dp)
            )
            if (user.isNotBlank()) {
                Text(text = "Bem-Vindo(a), ${user}", style = MaterialTheme.typography.h6)
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
                    value = user,
                    onValueChange = { onUserChange(it) },
                    label = { Text("Usuário") },
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordState,
                    onValueChange = { passwordState = it },
                    label = { Text("Senha") },
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Esqueci a senha")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    //Text(text = "  |  ")
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Cadastrar-se")
                    }
                }
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Button(
                    onClick = {
                        if (user.equals("admin") && passwordState.equals("admin")) {
                            onSuccess()
                            Toast.makeText(context, "Logado!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Login inválido!", Toast.LENGTH_SHORT).show()

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppGerenciadorViagensTheme {
        App()
    }
}