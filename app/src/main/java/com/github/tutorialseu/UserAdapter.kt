package com.github.tutorialseu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.tutorialseu.models.User

class UserAdapter( private val context: Context, private val items: ArrayList<User> ) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    /** Infla las vistas de elementos que están diseñadas en el archivo de diseño xml
     *  Crea una nueva {@link ViewHolder} e inicializa algunos campos privados para ser utilizados por RecyclerView. */
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): ViewHolder {

        return ViewHolder(
            LayoutInflater
                    .from( context )
                    .inflate(
                        R.layout.item_user_layout,
                        parent,
                        false
                    )
        )
    }

    /** Vincula cada elemento de ArrayList a una vista
     *  Se llama cuando RecyclerView necesita un nuevo {@link ViewHolder} del tipo especificado para representar un elemento..
     *  Este nuevo ViewHolder debe construirse con una nueva Vista que pueda representar los elementos del tipo dado. Puede crear una nueva vista manualmente o inflarla desde un archivo de diseño XML. */
    override fun onBindViewHolder( holder: ViewHolder, position: Int ) {

        val item = items.get( position )

        holder.tvId.text = item.id.toString()
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email
        holder.tvGender.text = item.gender
        holder.tvWeight.text = item.weight.toString()
        holder.tvHeight.text = item.height.toString()
        holder.tvMobileNumber.text = item.phone.mobile
        holder.tvOfficeNumber.text = item.phone.office
    }

    /** Obtiene el número de elementos de la lista */
    override fun getItemCount(): Int {
        return items.size
    }

    /** Un ViewHolder describe una vista de elemento y metadatos sobre su lugar dentro de RecyclerView. */
    class ViewHolder( view: View ) : RecyclerView.ViewHolder( view ) {
        // Holds the TextView that will add each item to
        val tvId: TextView = view.findViewById<TextView>( R.id.tv_id )
        val tvName: TextView = view.findViewById<TextView>( R.id.tv_name )
        val tvEmail: TextView = view.findViewById<TextView>( R.id.tv_email )
        val tvGender: TextView = view.findViewById<TextView>( R.id.tv_gender )
        val tvWeight: TextView = view.findViewById<TextView>( R.id.tv_weight )
        val tvHeight: TextView = view.findViewById<TextView>( R.id.tv_height )
        val tvMobileNumber: TextView = view.findViewById<TextView>( R.id.tv_mobile )
        val tvOfficeNumber: TextView = view.findViewById<TextView>( R.id.tv_office_number )
    }

}