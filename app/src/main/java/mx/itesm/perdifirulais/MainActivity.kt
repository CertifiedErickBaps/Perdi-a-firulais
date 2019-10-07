package mx.itesm.perdifirulais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.etMail
import kotlinx.android.synthetic.main.activity_main.etPassword
import kotlinx.android.synthetic.main.activity_register.*


class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInfo.setOnClickListener {
            Log.d("_Log_","SI LE PUCHO Y FUNCA")
        }

        mAuth = FirebaseAuth.getInstance()

        btnIngresar.setOnClickListener {
            //Log.d("Email", etUsuario.text.toString())
            if(etMail.toString().isEmpty() || etPassword.toString().isEmpty()){
                return@setOnClickListener
            }
            else{
            }
        }
        btnRegistro.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }



}
