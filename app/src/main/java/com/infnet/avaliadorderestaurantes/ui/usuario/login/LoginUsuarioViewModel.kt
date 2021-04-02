package com.infnet.avaliadorderestaurantes.ui.usuario.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.avaliadorderestaurantes.database.UsuarioFirebaseDao

class LoginUsuarioViewModel : ViewModel() {
    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun verificarCredenciais(email: String, senha: String) {
        UsuarioFirebaseDao.verificarCredencias(email, senha).addOnSuccessListener {
            _status.value = true
        }.addOnFailureListener {
            _msg.value = it.message
        }
    }
}