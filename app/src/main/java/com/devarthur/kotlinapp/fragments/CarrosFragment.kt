package com.devarthur.kotlinapp.fragments


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.devarthur.kotlinapp.domain.tipoCarro

import com.devarthur.kotlinapp.R
import com.devarthur.kotlinapp.adapter.CarroAdapter
import com.devarthur.kotlinapp.domain.Carro
import com.devarthur.kotlinapp.domain.CarroService
import kotlinx.android.synthetic.main.fragment_carros.*
import org.jetbrains.anko.support.v4.toast

private var type : tipoCarro = tipoCarro.classicos

class CarrosFragment : BaseFragment() {

    private var carros = listOf<Carro>()
    var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Check for the paramater that has been sent for the fragment
        type = arguments?.getSerializable("type") as tipoCarro
    }

    //Creates a view for the fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment_carros, container, false)

        //Conversts string resource to string



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Views
        recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.setHasFixedSize(true)


    }

    override fun onResume() {
        super.onResume()
        taskCarros()
    }

    private fun taskCarros() {
        //Search the itens
        this.carros = CarroService.getItens(context!!, type)

        Log.d("arthurdebug", "Itens service: ${this.carros.toString()}")

        //Updates the list
        recyclerView?.adapter = CarroAdapter(carros,
            { carro : Carro ->
              toast("@Clicou no item ${carro.itemName}")
            }

        )
    }
}
