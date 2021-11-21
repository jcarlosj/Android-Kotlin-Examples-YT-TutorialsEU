package com.github.tutorialseu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.tutorialseu.R

class ItemAdapter(val context: Context, val items: ArrayList<String>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    /** Infla las vistas de elementos que están diseñadas en el archivo de diseño xml
     *  crea un nuevo {@link ViewHolder} e inicializa algunos campos privados para que los utilice RecyclerView. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row_linear_layout,
                parent,
                false
            )
        )
    }

    /** Vincula cada elemento de ArrayList a una vista
     *  Se llama cuando RecyclerView necesita un nuevo {@link ViewHolder} del tipo especificado para representar un item
     *  Este nuevo ViewHolder debe construirse con una nueva Vista que pueda representar los elementos del tipo dado. Puede crear una nueva vista manualmente o inflarla desde un archivo de diseño XML.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        holder.tvItem.text = item

        // Actualización del color de fondo de acuerdo con las posiciones pares / impares en la lista.
        if (position % 2 == 0) {
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorLightGray
                )
            )
        } else {
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorWhite
                )
            )
        }
    }

    /** Obtiene el número de elementos de la lista */
    override fun getItemCount(): Int {
        return items.size
    }

    /** Un ViewHolder describe una vista de elemento y metadatos sobre su lugar dentro de RecyclerView. */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Contiene el TextView que agregará cada elemento a
        val tvItem = view.findViewById<TextView>( R.id.tv_item_name )
        val cardViewItem = view.findViewById<CardView>( R.id.card_view_item )
    }
}