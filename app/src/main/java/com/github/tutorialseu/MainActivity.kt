package com.github.tutorialseu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tutorialseu.models.User
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main )

        val usersList: ArrayList<User> = ArrayList()                //  Instancia lista de usuarios usando la clase de modelo de datos.

        try {
            val obj = JSONObject( getJSONFromAssets()!! )           //  Obtiene String JSON del archivo en el directorio assets
            val usersArray = obj.getJSONArray("users")        //  Obtiene un Array de la propiedad users

            // Iteramos el Array para obtener cada uno de sus valores
            for ( i in 0 until usersArray.length() ) {
                val user = usersArray.getJSONObject( i )            //  Crea un objeto JSON de para obtener los datos de cada usuario en la iteración

                val id = user.getInt("id")                    //  Obtiene el id del usuario como un tipo entero
                val name = user.getString("name")             //  Obtiene el nombre del usuario como un tipo cadena
                val email = user.getString("email")           //  Obtiene el correo del usuario como un tipo cadena
                val gender = user.getString("gender")         //  Obtiene el genero del usuario como un tipo cadena
                val weight = user.getDouble("weight")         //  Obtiene el ancho del usuario como un tipo de doble precision
                val height = user.getInt("height")            //  Obtiene el ancho del usuario como un tipo entero

                val phone = user.getJSONObject("phone")       //  Crea un objeto JSON de la propiedad 'phone' de para obtener los datos contenidos en él
                val mobile = phone.getString("mobile")        //  Obtiene el # del movil del usuario como un tipo entero del campo 'mobile', contenido en la propiedad 'phone'
                val office = phone.getString("office")        //  Obtiene el # de la oficina del usuario como un tipo entero del campo 'mobile', contenido en la propiedad 'phone'

                val userDetails = User( id, name, email, gender, weight, height, mobile, office )       // Agregua todos los valores extraidos a la instancia a la clase User.

                usersList.add( userDetails )                        // Agregua cada usuario a un Objeto de tipo Lista
            }
        } catch ( e: JSONException ) {
            //exception
            e.printStackTrace()
        }

        val rvUserList: RecyclerView = findViewById( R.id.rvUserList )      //  Obtiene el View del Activity
        rvUserList.layoutManager = LinearLayoutManager(this)         //  Configura el LayoutManager que utilizará este RecyclerView, pasandole el contexto.

        val itemAdapter = UserAdapter(this, usersList)               // Inicializa el Adapter pasa el contexto y la lista con la data
        rvUserList.adapter = itemAdapter                                     // Establece en la vista de reciclaje para inflar los elementos.

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