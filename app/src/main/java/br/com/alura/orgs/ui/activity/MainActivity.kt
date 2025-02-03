package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity :
    AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
                Produto(nome = "teste",
                        descricao = "teste desc",
                        valor = BigDecimal("19.99")
                ),
                Produto(nome = "teste 1",
                        descricao = "teste desc 1",
                        valor = BigDecimal("29.99")
                ),
                Produto(nome = "teste 2",
                        descricao = "teste desc 2",
                        valor = BigDecimal("39.99")
                ),
        ))

    }

}