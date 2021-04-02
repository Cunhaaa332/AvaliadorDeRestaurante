package com.infnet.avaliadorderestaurantes.ui.avaliacao.listTotalAvaliacoes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import com.infnet.avaliadorderestaurantes.model.Avaliacao

class ListRestaurantesViewModel(private val avaliacaoDao: AvaliacaoDao) : ViewModel() {
    private val _avaliacoes = MutableLiveData<MutableList<Avaliacao>>()
    val avaliacoes: LiveData<MutableList<Avaliacao>> = _avaliacoes

    fun attListAvaliacoesForAllUser () {
        avaliacaoDao.allForAllUsers().addOnSuccessListener {
            val avaliacoesFB = it.toObjects(Avaliacao::class.java)
            _avaliacoes.value = avaliacoesFB
        }.addOnFailureListener {
            Log.i("ListAvaliacoesFrag", "${it.message}")
        }

    }
}