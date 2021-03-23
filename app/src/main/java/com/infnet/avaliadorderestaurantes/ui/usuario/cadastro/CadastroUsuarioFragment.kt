package com.infnet.avaliadorderestaurantes.ui.usuario.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.R

class CadastroUsuarioFragment : Fragment() {

    companion object {
        fun newInstance() = CadastroUsuarioFragment()
    }

    private lateinit var viewModel: CadastroUsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastro_usuario_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastroUsuarioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}