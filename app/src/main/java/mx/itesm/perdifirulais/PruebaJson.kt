package mx.itesm.perdifirulais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import okhttp3.*
import java.io.IOException

class PruebaJson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba_json)
        AndroidNetworking.initialize(this)

        obtenerJson()
    }

    private fun obtenerJson() {
        val url = "https://www.googleapis.com/books/v1/volumes?q=title:android"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)
            }

        })
    }
}