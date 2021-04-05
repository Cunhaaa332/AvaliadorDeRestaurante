package com.infnet.avaliadorderestaurantes.ui.avaliacao.form

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.infnet.avaliadorderestaurantes.R
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDaoFirestore
import com.infnet.avaliadorderestaurantes.database.CriptoString
import kotlinx.android.synthetic.main.form_avaliacao_fragment.*
import kotlinx.android.synthetic.main.list_avaliacoes_fragment.*

class FormAvaliacaoFragment : Fragment() {

    private lateinit var viewModel: FormAvaliacaoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.form_avaliacao_fragment, container, false)

        val formAvaliacaoViewModelFactory = FormAvaliacaoViewModelFactory(AvaliacaoDaoFirestore())

        viewModel = ViewModelProvider(this, formAvaliacaoViewModelFactory).get(FormAvaliacaoViewModel::class.java)

        viewModel.let {
            it.message.observe(viewLifecycleOwner){ message ->
                if(!message.isNullOrBlank()){
                    makeToast(message)
                }
            }
            it.status.observe(viewLifecycleOwner){ status ->
                if(status) {
                    findNavController().popBackStack(R.id.listAvaliacoesFragment, false)
                }
            }
        }
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewBackCadAv.setOnClickListener{
            findNavController().popBackStack()
        }

        btnCadastrarAvaliacao.setOnClickListener {
            val nomeDoRestaurante = CriptoString()
            nomeDoRestaurante.setClearText(inputTextNomeRestaurante.text.toString())
            val bairro = CriptoString()
            bairro.setClearText(inputTextBairroRestaurante.text.toString())
            val respostaA = pegaRespostaQ1()
            val respostaB = pegaRespostaQ2()
            val respostaC = pegaRespostaQ3()
            val respostaD = pegaRespostaQ4()
            val respostaE = pegaRespostaQ5()
            val respostaF = pegaRespostaQ6()
            val porcentagem = pegaPorcentagem(respostaA, respostaB, respostaC, respostaD, respostaE, respostaF)

            viewModel.salvarAvaliacao(nomeDoRestaurante, bairro, respostaA, respostaB, respostaC,
                                      respostaD, respostaE, respostaF, porcentagem)
        }
    }

    private fun makeToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    private fun pegaRespostaQ1(): String {
        var resposta : String
        if(cbSimQst1.isChecked){
            resposta = "Sim"
        }
        else{
            resposta = "Não"
        }
        return resposta
    }

    private fun pegaRespostaQ2(): String {
        var resposta : String
        if(cbSimQst2.isChecked){
            resposta = "Sim"
        }
        else{
            resposta = "Não"
        }
        return resposta
    }

    private fun pegaRespostaQ3(): String {
        var resposta : String
        if(cbSimQst3.isChecked){
            resposta = "Sim"
        }
        else{
            resposta = "Não"
        }
        return resposta
    }

    private fun pegaRespostaQ4(): String {
        var resposta : String
        if(cbSimQst4.isChecked){
            resposta = "Sim"
        }
        else{
            resposta = "Não"
        }
        return resposta
    }

    private fun pegaRespostaQ5(): String {
        var resposta : String
        if(cbSimQst5.isChecked){
            resposta = "Sim"
        }
        else{
            resposta = "Não"
        }
        return resposta
    }

    private fun pegaRespostaQ6(): String {
        var resposta : String
        if(cbSimQst6.isChecked){
            resposta = "Sim"
        }
        else{
            resposta = "Não"
        }
        return resposta
    }

    private fun pegaPorcentagem(a:String, b: String, c: String, d:String, e:String, f:String): Float {
        var respostasSim = 0;
        var respostas = listOf(a, b, c, d, e, f)
        var i = 0

        while (i < respostas.count()){
            if (respostas.get(i) == "Sim"){
                respostasSim ++
            }
            i++
        }

        var porcentagem = when(respostasSim){
            1 ->  16.7f
            2 ->  33.4f
            3 ->  50.0f
            4 ->  66.7f
            5 ->  83.4f
            6 ->  100.0f
            else -> 0f
        }
        return porcentagem
    }
}