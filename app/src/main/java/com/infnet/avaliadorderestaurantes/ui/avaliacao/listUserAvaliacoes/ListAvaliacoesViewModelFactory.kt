package com.infnet.avaliadorderestaurantes.ui.avaliacao.listUserAvaliacoes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import java.lang.IllegalArgumentException

class ListAvaliacoesViewModelFactory(private val avaliacaoDao: AvaliacaoDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListAvaliacoesViewModel::class.java))
            return ListAvaliacoesViewModel(avaliacaoDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}