package com.infnet.avaliadorderestaurantes.ui.avaliacao.listUserAvaliacoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.infnet.avaliadorderestaurantes.R
import com.infnet.avaliadorderestaurantes.database.AvaliacaoDaoFirestore
import com.infnet.avaliadorderestaurantes.database.AvaliacaoUtil
import com.infnet.avaliadorderestaurantes.database.UsuarioFirebaseDao
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

        viewModel.usuario.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                textViewUserName.text = it.nome + " " + it.sobrenome
            }
            else if(UsuarioFirebaseDao.firebaseAuth.currentUser == null) {
                findNavController().navigate(R.id.loginUsuarioFragment)
                textViewUserName.text = null
            }
        })
        viewModel.attPerfil()

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
        fabLogOut.setOnClickListener{
            viewModel.encerrarSessao()
        }
    }
}