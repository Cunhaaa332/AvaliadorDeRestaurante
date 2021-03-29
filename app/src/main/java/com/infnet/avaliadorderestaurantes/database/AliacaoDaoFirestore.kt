package com.infnet.avaliadorderestaurantes.database

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.infnet.avaliadorderestaurantes.model.Avaliacao

class AliacaoDaoFirestore: AvaliacaoDao {
    private val collection = FirebaseFirestore.getInstance().collection("avaliacoes")
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun insert(avaliacao: Avaliacao): Task<DocumentReference> {
        avaliacao.usuarioId = firebaseAuth.currentUser.uid
        return collection.add(avaliacao)
    }

    override fun delete(avaliacao: Avaliacao): Task<Void> {
        return collection.document(avaliacao.id!!).delete()
    }

    override fun all(): Query {
        return collection.whereEqualTo("usuarioId", firebaseAuth.currentUser.uid)
    }

    override fun allForAllUsers(): Task<QuerySnapshot> {
        return collection.get()
    }

    override fun read(key: String): Query {
        return collection.whereEqualTo("id", key)
    }

    override fun edit(avaliacao: Avaliacao): Task<Void> {
        return collection.document(avaliacao.id!!).set(avaliacao)
    }
}