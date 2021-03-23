package com.infnet.avaliadorderestaurantes.ui.avaliacao.listUserAvaliacoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.R

class ListAvaliacoesFragment : Fragment() {

    companion object {
        fun newInstance() = ListAvaliacoesFragment()
    }

    private lateinit var viewModel: ListAvaliacoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_avaliacoes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListAvaliacoesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}