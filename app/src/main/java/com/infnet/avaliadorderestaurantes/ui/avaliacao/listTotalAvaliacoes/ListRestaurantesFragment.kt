package com.infnet.avaliadorderestaurantes.ui.avaliacao.listTotalAvaliacoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.infnet.avaliadorderestaurantes.R

class ListRestaurantesFragment : Fragment() {

    companion object {
        fun newInstance() = ListRestaurantesFragment()
    }

    private lateinit var viewModel: ListRestaurantesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_restaurantes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListRestaurantesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}