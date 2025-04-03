package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.carregarImagem

class FormularioImageDialog (private val context: Context){

    fun mostrarDialog(
        urlPadrao: String? = null,
        imagemCarregada: (imagem: String) -> Unit
    ) {
       FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {
                urlPadrao?.let {
                    formularioImagemImageview.carregarImagem(it)
                    formularioImagemUrl.setText(it)
                }

              formularioImagemBotaoCarregar.setOnClickListener {
                   val url =formularioImagemUrl.text.toString()
                  formularioImagemImageview.carregarImagem(url)
               }

               AlertDialog.Builder(context)
                   .setView(root)
                   .setPositiveButton("Confirmar") { _, _ ->
                       val url =formularioImagemUrl.text.toString()
                       imagemCarregada(url)
                   }
                   .setNegativeButton("Cancelar") { _, _ ->
                   }
                   .show()
            }
    }
}