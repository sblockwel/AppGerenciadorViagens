package com.example.appgerenciadorviagens.views

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appgerenciadorviagens.viewModels.LoginViewModel
import com.example.appgerenciadorviagens.viewModels.TravelViewModel
import java.text.DecimalFormat

@Composable
fun travelView() {
    val travelModel: TravelViewModel = viewModel()
    val travels = listOf(
        Produto("Caneta", "Caneta azul muito boa", 10.0),
        Produto(nome = "Monitor", valor = 15.0),
        Produto("CPU", "I7", 100.5)
    )

    LazyColumn() {
        items(items = travels) { p ->
            ProdutoView(p)
        }
    }
}

@Composable
fun ProdutoView(travel: TravelViewModel) {
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
                        "destino: ${travelModel.destino}",
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
                Text(text = produto.nome)
                Text(
                    text = produto.descricao,
                    style = MaterialTheme.typography.caption
                )
            }
            Text(
                text = "R$ ${df.format(produto.valor)}",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)

            )
        }
    }

}