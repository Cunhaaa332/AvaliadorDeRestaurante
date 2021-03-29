package com.infnet.avaliadorderestaurantes.database

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.infnet.avaliadorderestaurantes.model.Avaliacao

interface AvaliacaoDao {
    fun insert(avaliacao: Avaliacao) : Task<DocumentReference>

    fun delete(avaliacao: Avaliacao) : Task<Void>

    fun all(): Query

    fun allForAllUsers(): Task<QuerySnapshot>

    fun read(key: String): Query

    fun edit(avaliacao: Avaliacao): Task<Void>
}