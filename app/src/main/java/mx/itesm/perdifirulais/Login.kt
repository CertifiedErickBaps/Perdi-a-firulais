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
import kotlinx.coroutines.selects.SelectInstance


class Login : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegistro.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        mAuth = FirebaseAuth.getInstance()



        btnIngresar.setOnClickListener{
            login()
        }
    }


    private fun login(){
        mAuth.signInWithEmailAndPassword(etMail.text.toString(),etPassword.text.toString())
            .addOnCompleteListener(this){
                task ->
                if (task.isSuccessful){
                        startActivity(Intent(this, Seleccion::class.java))
                }
            }
    }



}
