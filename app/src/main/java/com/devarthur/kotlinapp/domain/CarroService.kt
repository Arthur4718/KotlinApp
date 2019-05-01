package com.devarthur.kotlinapp.domain

import android.content.Context

//* Created by Arthur Gomes at 2019-05-01 00:19 - contact me at devarthur4718@gmail.com.br
object CarroService {
    //Serch itens by type


        fun getItens(context : Context, tipo : tipoCarro) : List<Carro>{

            val item_type = context.getString(tipo.string)

            val carros =  mutableListOf<Carro>()

            for(i in 1..20){
                val item = Carro()
                //Dinamic item name

                item.itemName = "Item $item_type : $i"
                item.desc = "Desc " + i
                //img url
                item.urlFoto = "http://www.livroandroid.com.br/livro/carros/espertivos/Ferrari_FF.png"
                carros.add(item)
            }
            return carros
        }

}