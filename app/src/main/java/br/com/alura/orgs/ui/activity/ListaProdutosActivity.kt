package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity :
    AppCompatActivity() {

    private lateinit var binding: ActivityListaProdutosBinding
    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configuraRecyclerView()
        configuraFab()
        AlertDialog.Builder(this)
            .setTitle("Atenção")
            .setMessage("Deseja realmente sair?")
            .setPositiveButton("Sim") { _, _ ->
                finish()
            }
            .setNegativeButton("Não", null)
            .create()
            .show()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }


    private fun configuraFab() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
          vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProduto::class.java)
        startActivity(intent)
    }


    private fun configuraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
    }

}