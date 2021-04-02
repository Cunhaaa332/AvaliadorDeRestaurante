package com.infnet.avaliadorderestaurantes.ui.usuario.cadastro

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
import kotlinx.android.synthetic.main.cadastro_usuario_fragment.*

class CadastroUsuarioFragment : Fragment() {
    private lateinit var viewModel: CadastroUsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cadastro_usuario_fragment, container, false)
        viewModel = ViewModelProvider(this).get(CadastroUsuarioViewModel::class.java)
        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it)
                findNavController().popBackStack()
        })

        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank())
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCadastrar.setOnClickListener {
            val senha = inputSenhaUsuarioCad.text.toString()
            val resenha = inputConfirmaSenhaUsuarioCad.text.toString()
            if(senha.length >= 6){
                if(senha == resenha){
                    val email = inputEmailUsuarioCad.text.toString()
                    val nome = inputNomeUsuarioCad.text.toString()
                    val sobrenome = inputSobrenomeUsuarioCad.text.toString()
                    viewModel.salvarCadastro(email, senha, nome, sobrenome)
                }else{
                    Toast.makeText(requireContext(), "Senhas não batem.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(), "Senha deve conter mais de 6 caracteres.", Toast.LENGTH_SHORT).show()
            }

        }
    }

}