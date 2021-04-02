package com.infnet.avaliadorderestaurantes.model

import com.google.firebase.firestore.DocumentId

class Avaliacao (
        var nomeDoRestaurante: String? = null,
        var bairro: String? = null,
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
        override fun toString(): String =
                "Nome do Restaurante: $nomeDoRestaurante \n" +
                "Bairro do Restaurante: $bairro \n" +
                "Porcentagem da Avaliação: $porcentagem%"


}
