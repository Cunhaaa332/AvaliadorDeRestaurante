package com.infnet.avaliadorderestaurantes.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.DocumentId
import com.infnet.avaliadorderestaurantes.database.CriptoString

class Avaliacao (
        var nomeDoRestaurante: CriptoString? = null,
        var bairro: CriptoString? = null,
        var respostaA: String? = null,
        var respostaB: String? = null,
        var respostaC: String? = null,
        var respostaD: String? = null,
        var respostaE: String? = null,
        var respostaF: String? = null,
        var porcentagem: Float? = null,
        var usuarioId: String? = null,
        @DocumentId
        var id: String? = null
        ){
        @RequiresApi(Build.VERSION_CODES.M)
        override fun toString(): String =
                "Nome do Restaurante: ${nomeDoRestaurante!!.getClearText().toString()} \n" +
                "Bairro do Restaurante: ${bairro!!.getClearText().toString()} \n" +
                "Porcentagem da Avaliação: $porcentagem%"


}
