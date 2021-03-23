package com.infnet.avaliadorderestaurantes.ui.avaliacao.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.R

class FormAvaliacaoFragment : Fragment() {

    companion object {
        fun newInstance() = FormAvaliacaoFragment()
    }

    private lateinit var viewModel: FormAvaliacaoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_avaliacao_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormAvaliacaoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}