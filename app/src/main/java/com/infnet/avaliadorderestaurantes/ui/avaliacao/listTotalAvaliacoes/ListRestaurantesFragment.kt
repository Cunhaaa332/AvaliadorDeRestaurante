package com.infnet.avaliadorderestaurantes.ui.avaliacao.listTotalAvaliacoes

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
import kotlinx.android.synthetic.main.list_avaliacoes_fragment.*
import kotlinx.android.synthetic.main.list_restaurantes_fragment.*

class ListRestaurantesFragment : Fragment() {
    private lateinit var viewModel: ListRestaurantesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_restaurantes_fragment, container, false)
        val listRestaurantesViewModelFactory = ListRestaurantesViewModelFactory(AvaliacaoDaoFirestore())
        viewModel = ViewModelProvider(this, listRestaurantesViewModelFactory).get(ListRestaurantesViewModel::class.java)

        viewModel.avaliacoes.observe(viewLifecycleOwner) {
            listViewAllAv.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
        }
        viewModel.attListAvaliacoesForAllUser()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewBackListAll.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}