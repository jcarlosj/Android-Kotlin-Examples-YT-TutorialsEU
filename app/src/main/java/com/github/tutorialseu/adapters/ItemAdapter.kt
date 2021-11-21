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
import com.github.tutorialseu.models.DataModel

class ItemAdapter( private val context: Context, private val items: ArrayList<DataModel> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /** Un objeto complementario donde podemos declarar los valores constantes. */
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    /** Infla las vistas de elementos que están diseñadas en el archivo de diseño xml
     *  crea un nuevo {@link ViewHolder} e inicializa algunos campos privados para que los utilice RecyclerView. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if ( viewType == VIEW_TYPE_ONE ) {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_row_linear_layout,
                    parent,
                    false
                )
            )
        } else {
            return AnotherViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_row_new_layout,
                    parent,
                    false
                )
            )
        }
    }

    /** Vincula cada elemento de ArrayList a una vista
     *  Se llama cuando RecyclerView necesita un nuevo {@link ViewHolder} del tipo especificado para representar un elemento.
     *  Este nuevo ViewHolder debe construirse con una nueva Vista que pueda representar los elementos del tipo dado. Puede crear una nueva vista manualmente o inflarla desde un archivo de diseño XML. */
    override fun onBindViewHolder( holder: RecyclerView.ViewHolder, position: Int ) {

        val item = items[ position ]

        if ( holder is ViewHolder ) {
            holder.tvItem.text = item.itemName

            // Actualización del color de fondo de acuerdo con las posiciones pares / impares en la lista.
            if ( position % 2 == 0 ) {
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
        } else if ( holder is AnotherViewHolder ) {
            holder.tvAnotherItemName.text = item.itemName

            // Actualización del color de fondo de acuerdo con las posiciones pares / impares en la lista.
            if ( position % 2 == 0 ) {
                holder.cardViewAnotherItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorLightGray
                    )
                )
            } else {
                holder.cardViewAnotherItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorWhite
                    )
                )
            }
        }
    }

    /** Obtiene el número de elementos de la lista */
    override fun getItemCount(): Int {
        return items.size
    }

    /** Obtenga ItemViewType de los elementos de la lista. */
    override fun getItemViewType( position: Int ): Int {
        return items[ position ].viewType
    }

    /** Un ViewHolder describe una vista de elemento y metadatos sobre su lugar dentro de RecyclerView. */
    class ViewHolder( view: View ) : RecyclerView.ViewHolder( view ) {
        // Contiene el TextView que agregará a cada elemento
        val tvItem: TextView = view.findViewById( R.id.tv_item_name )
        val cardViewItem: CardView = view.findViewById( R.id.card_view_item )
    }

    class AnotherViewHolder( view: View ) : RecyclerView.ViewHolder( view ) {
        // Contiene el TextView que agregará a cada elemento
        val tvAnotherItemName: TextView = view.findViewById( R.id.tv_another_item_name )
        val cardViewAnotherItem: CardView = view.findViewById( R.id.card_view_another_item )
    }
}