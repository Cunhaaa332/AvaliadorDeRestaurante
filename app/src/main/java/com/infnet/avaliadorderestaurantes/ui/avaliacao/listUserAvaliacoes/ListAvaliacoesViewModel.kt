package com.infnet.avaliadorderestaurantes.ui.avaliacao.listUserAvaliacoes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDao
import com.infnet.avaliadorderestaurantes.database.UsuarioFirebaseDao
import com.infnet.avaliadorderestaurantes.model.Avaliacao
import com.infnet.avaliadorderestaurantes.model.Usuario

class ListAvaliacoesViewModel(private val avaliacaoDao: AvaliacaoDao) : ViewModel() {
    private val _avaliacoes = MutableLiveData<MutableList<Avaliacao>>()
    val avaliacoes: LiveData<MutableList<Avaliacao>> = _avaliacoes
    private val _usuario = MutableLiveData<Usuario?>()
    val usuario: LiveData<Usuario?> = _usuario

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

    fun attPerfil() {
        UsuarioFirebaseDao.consultarUsuario().addOnSuccessListener {
            val usuario = it.toObject(Usuario::class.java)
            usuario!!.firebaseUser = UsuarioFirebaseDao.firebaseAuth.currentUser
            usuario.email = UsuarioFirebaseDao.firebaseAuth.currentUser.email
            _usuario.value = usuario!!
        }
    }

    fun encerrarSessao() {
        UsuarioFirebaseDao.encerrarSessao()
        _usuario.value = null
    }
}