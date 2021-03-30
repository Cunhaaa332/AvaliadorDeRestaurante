package com.infnet.avaliadorderestaurantes.ui.avaliacao.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao

class FormAvaliacaoViewModel(private val avaliacaoDao: AvaliacaoDao) : ViewModel() {
    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _message = MutableLiveData<String?>()
    val message: LiveData<String?> = _message

    init {
        _status.value = false
        _message.value = null
    }


}