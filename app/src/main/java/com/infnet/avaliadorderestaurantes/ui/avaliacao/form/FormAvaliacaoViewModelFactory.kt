package com.infnet.avaliadorderestaurantes.ui.avaliacao.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import java.lang.IllegalArgumentException

class FormAvaliacaoViewModelFactory(val avaliacaoDao: AvaliacaoDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FormAvaliacaoViewModel::class.java)){
            return FormAvaliacaoViewModel(avaliacaoDao) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}