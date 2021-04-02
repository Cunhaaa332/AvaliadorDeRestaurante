package com.infnet.avaliadorderestaurantes.ui.avaliacao.listUserAvaliacoes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import com.infnet.avaliadorderestaurantes.model.Avaliacao

class ListAvaliacoesViewModel(private val avaliacaoDao: AvaliacaoDao) : ViewModel() {
    private val _avaliacoes = MutableLiveData<MutableList<Avaliacao>>()
    val avaliacoes: LiveData<MutableList<Avaliacao>> = _avaliacoes

    fun attListAvaliacoes () {
        avaliacaoDao.all().addSnapshotListener { value, error ->
            if (error != null) {
                Log.i("FirebaseFirestore", "${error.message}")
            } else {
                if (value != null && !value.isEmpty) {
                    _avaliacoes.value = value.toObjects(Avaliacao::class.java)
                }
            }
        }
    }
}