package com.devarthur.kotlinapp.domain

//* Created by Arthur Gomes at 2019-05-01 00:13 - contact me at devarthur4718@gmail.com.br
class Carro {
    var itemId:Long = 0
    var type = 0
    var itemName = ""
    var desc = ""
    var urlFoto = ""
    var urlInfo = ""
    var urlVideo = ""
    var latitude = ""
    var longitute = ""

    override fun toString(): String{
        return "Carro(nome='$itemName')"
    }


}