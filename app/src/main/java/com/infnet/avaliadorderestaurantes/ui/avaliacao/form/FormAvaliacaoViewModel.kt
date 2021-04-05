package com.infnet.avaliadorderestaurantes.ui.avaliacao.form

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import com.infnet.avaliadorderestaurantes.database.CriptoString
import com.infnet.avaliadorderestaurantes.model.Avaliacao

class FormAvaliacaoViewModel(private val avaliacaoDao: AvaliacaoDao) : ViewModel() {
    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _message = MutableLiveData<String?>()
    val message: LiveData<String?> = _message

    init {
        _status.value = false
        _message.value = null
    }

    fun salvarAvaliacao(nomedoRestaurante: CriptoString, bairro: CriptoString, respostaA: String,
                        respostaB: String, respostaC: String, respostaD: String,
                        respostaE: String, respostaF: String, porcentagem: Float){

        val avaliacao = Avaliacao(nomedoRestaurante, bairro, respostaA, respostaB, respostaC,
                                  respostaD, respostaE, respostaF, porcentagem)
        avaliacaoDao.insert(avaliacao).addOnSuccessListener {
            _status.value = true
            _message.value = "Persistência realizada com êxito!"
        }.addOnFailureListener{
            _message.value = "Falha na persistência!"
            Log.e("SerieDaoFirebase", "${it.message}")
        }
    }
}