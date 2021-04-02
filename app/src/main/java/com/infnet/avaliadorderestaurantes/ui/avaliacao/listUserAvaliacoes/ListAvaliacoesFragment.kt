package com.infnet.avaliadorderestaurantes.ui.avaliacao.listUserAvaliacoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.infnet.avaliadorderestaurantes.R
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDaoFirestore
import com.infnet.avaliadorderestaurantes.database.AvaliacaoUtil
import kotlinx.android.synthetic.main.list_avaliacoes_fragment.*

class ListAvaliacoesFragment : Fragment() {

    private lateinit var viewModel: ListAvaliacoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_avaliacoes_fragment, container, false)
        val listAvaliacoesViewModelFactory = ListAvaliacoesViewModelFactory(AvaliacaoDaoFirestore())
        viewModel = ViewModelProvider(this, listAvaliacoesViewModelFactory).get(ListAvaliacoesViewModel::class.java)

        viewModel.avaliacoes.observe(viewLifecycleOwner){
            listViewAvaliacoesUser.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
            listViewAvaliacoesUser.setOnItemClickListener { parent, view, position, id ->
                val avaliacao = it.get(position)
                AvaliacaoUtil.avaliacaoSelecionada = avaliacao
                findNavController().navigate(R.id.formAvaliacaoFragment)
            }
        }
        viewModel.attListAvaliacoes()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fabAddAv.setOnClickListener{
            AvaliacaoUtil.avaliacaoSelecionada = null
            findNavController().navigate(R.id.formAvaliacaoFragment)
        }
        fabAllAv.setOnClickListener{
            findNavController().navigate(R.id.listRestaurantesFragment)
        }
    }
}