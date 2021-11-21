package com.github.tutorialseu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tutorialseu.models.User
import com.github.tutorialseu.models.UserList
import com.google.gson.Gson
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main )

        try {
            val jsonString = getJSONFromAssets()!!                                  //  Obtiene String JSON del archivo en el directorio assets
            val usersList = Gson().fromJson( jsonString, UserList::class.java )     //  Obtiene Array de usuarios

            val rvUserList: RecyclerView = findViewById( R.id.rvUserList )      //  Obtiene el View del Activity
            rvUserList.layoutManager = LinearLayoutManager(this)         //  Configura el LayoutManager que utilizará este RecyclerView, pasandole el contexto.

            val itemAdapter = UserAdapter(this, usersList.users )        // Inicializa el Adapter pasa el contexto y la lista con la data
            rvUserList.adapter = itemAdapter                                     // Establece en la vista de reciclaje para inflar los elementos.

        } catch ( e: JSONException ) {
            //exception
            e.printStackTrace()
        }



    }


    /** Método para cargar el JSON desde el archivo de Activos y devolver el objeto */
    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8

        try {
            val myUsersJSONFile = assets.open("users.json")         //  Abre el archivo
            val size = myUsersJSONFile.available()                          //  Obtiene el tamaño del archivo
            val buffer = ByteArray( size )                                  //  Crea matriz de bytes

            myUsersJSONFile.read( buffer )                                  //  Lee la data del Buffer
            myUsersJSONFile.close()                                         //  Cierra el archivo una ves se termine de leer
            json = String( buffer, charset )                                //  Interpreta caracteres especiales del Charset establecido

        } catch (ex: IOException) {
            ex.printStackTrace()

            return null
        }

        return json
    }
}