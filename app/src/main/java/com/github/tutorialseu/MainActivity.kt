package com.github.tutorialseu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tutorialseu.adapters.ItemAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_view_items = findViewById<RecyclerView>( R.id.rv_data_list )

        // Configure el LayoutManager que utilizará este RecyclerView.
        recycler_view_items.layoutManager = GridLayoutManager( this, 2 )

        // Inicializa Adapter, se pasa el contexto y la lista como parámetro.
        val itemAdapter = ItemAdapter( this, getItemsList() )

        // La instancia del Adapter se establece en la vista de reciclaje para inflar los elementos.
        recycler_view_items.adapter = itemAdapter
    }

    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()

        for( i in 1..40 ){
            list .add( "Item $i" )
        }

        return list
    }
}