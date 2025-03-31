package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.carregarImagem

class FormularioImageDialog (private val context: Context){

    fun mostrarDialog(imagemCarregada:(imagem: String )-> Unit) {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))
        binding.formularioImagemBotaoCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            binding.formularioImagemImageview.carregarImagem(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.formularioImagemUrl.text.toString()
                imagemCarregada(url)
            }
            .setNegativeButton("Cancelar") { _, _ ->
            }
            .show()
    }
}