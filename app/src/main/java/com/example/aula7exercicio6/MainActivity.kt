package com.example.aula7exercicio6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: List<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Adicionando uma variável para rastrear a posição do último item clicado
    private var lastClickedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = item

        // Alternando as cores entre branco e cinza
        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.colorWhite)
        } else {
            holder.itemView.setBackgroundResource(R.color.colorGray)
        }

        // Adicionando o clique ao item
        holder.itemView.setOnClickListener {
            // Mudando a cor do item clicado para um destaque
            lastClickedPosition = position
            notifyDataSetChanged()
        }

        // Destacando o item clicado
        if (position == lastClickedPosition) {
            holder.itemView.setBackgroundResource(R.color.colorHighlight)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }
}
