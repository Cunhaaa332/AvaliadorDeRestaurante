package com.infnet.avaliadorderestaurantes.ui.usuario.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.R

class LoginUsuarioFragment : Fragment() {

    companion object {
        fun newInstance() = LoginUsuarioFragment()
    }

    private lateinit var viewModel: LoginUsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_usuario_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginUsuarioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}