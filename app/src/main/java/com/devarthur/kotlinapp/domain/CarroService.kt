package com.devarthur.kotlinapp.domain

import android.content.Context

//* Created by Arthur Gomes at 2019-05-01 00:19 - contact me at devarthur4718@gmail.com.br
object CarroService {

    //Search itens by tipe
    fun getItens(context : Context, tipo : tipoCarro) : List<Carro> {
        val tipoString = context.getString(tipo.string)

        //Creates an array
        val carros = mutableListOf<Carro>()

        //Creating 20 itens.
        val c = Carro()

        //Iten dynamic name.
        //c.itemName = "Carro $tipoString: $i "
        for(i in 1..20){
            //Dynamic item name.
            c.itemName = "Carro $tipoString: $i"
            c.desc = "Desc " + i

            //Fixed photo for test
            c.urlFoto = "https://cdn.jamesedition.com/media/W1siZiIsImxpc3RpbmdfaW1hZ2VzLzIwMTkvMDIvMTMvMTMvMTYvNTAvY2MxNmVlOTctNDk0MC00YzI1LWJmOTItZWZmNGU5ZDMyMDE3LzNBXzY0MC5qcGciXSxbInAiLCJ0aHVtYiIsIjYwMHgzNTQjIl0sWyJwIiwiZW5jb2RlIiwianBnIixudWxsXV0/2018-ferrari-gtc4-lusso.jpg?sha=f9da207ddf8f993e"

            carros.add(c)
        }

        return carros
    }

}