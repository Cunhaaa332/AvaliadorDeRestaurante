package com.infnet.avaliadorderestaurantes.ui.avaliacao.listTotalAvaliacoes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import java.lang.IllegalArgumentException

class ListRestaurantesViewModelFactory(private val avaliacaoDao: AvaliacaoDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListRestaurantesViewModel::class.java))
            return ListRestaurantesViewModel(avaliacaoDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}