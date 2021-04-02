package com.infnet.avaliadorderestaurantes.ui.usuario.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.infnet.avaliadorderestaurantes.R
import kotlinx.android.synthetic.main.login_usuario_fragment.*

class LoginUsuarioFragment : Fragment() {

    private lateinit var viewModel: LoginUsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_usuario_fragment, container, false)

        viewModel = ViewModelProvider(this).get(LoginUsuarioViewModel::class.java)
        viewModel.status.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(R.id.listAvaliacoesFragment)
            }
        })

        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrBlank())
                makeToast(it)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            val email = inputLoginUserLog.text.toString()
            val senha = inputSenhaUsuarioLog.text.toString()
            if(!email.isNullOrBlank() && !senha.isNullOrBlank()) {
                viewModel.verificarCredenciais(email, senha)
            }
            else {
                makeToast("Email e Senha obrigatórios.")
            }
        }
        btnIrCadastro.setOnClickListener {
            findNavController().navigate(R.id.cadastroUsuarioFragment)
        }
    }

    private fun makeToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

}