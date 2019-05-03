package com.devarthur.kotlinapp.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.devarthur.kotlinapp.R
import com.devarthur.kotlinapp.domain.Carro
import com.squareup.picasso.Picasso


//* Created by Arthur Gomes at 2019-05-01 00:56 - contact me at devarthur4718@gmail.com.br
// Defines the holder constructor  (carros,onClick)
class CarroAdapter(
    val carros: List<Carro>,
    val onClick: (Carro) -> Unit) :
    RecyclerView.Adapter<CarroAdapter.CarrosViewHolder>() {
    //Viewholder with the views
    class CarrosViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var tNome : TextView
        var img : ImageView
        var progress : ProgressBar
        var cardView : CardView

        init{
            //Stoes the views within the viewholder
            tNome = view.findViewById<TextView>(R.id.tNome)
            img = view.findViewById<ImageView>(R.id.img)
            progress = view.findViewById<ProgressBar>(R.id.card_progress)
            cardView = view.findViewById<CardView>(R.id.card_view)
        }
    }

    //Returns how many itens the recycler is currently holding.
    override fun getItemCount() = this.carros.size

    //Infatles the view inside the layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrosViewHolder {

        //Inflates the view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_carro, parent, false)

        //Returns the value of the view
        val holder = CarrosViewHolder(view)

        return holder

    }


    //Binds the views so the layout can update each value for feach item
    override fun onBindViewHolder(holder: CarrosViewHolder, position: Int) {
        val context = holder.itemView.context
        //Object reference by its position
        val carro = carros[position]

        //Updates the data

        holder.tNome.text = carro.itemName
        holder.progress.visibility = View.VISIBLE
        //Downloads and apply the image
        Picasso.with(context).load(carro.urlFoto).fit().into(holder.img, object  : com.squareup.picasso.Callback{
            override fun onSuccess() {
                //Download ok
                holder.progress.visibility = View.GONE
            }

            override fun onError() {
                holder.progress.visibility = View.GONE
            }

        })

        //Adds the click event
        holder.itemView.setOnClickListener { onClick(carro) }

    }
}