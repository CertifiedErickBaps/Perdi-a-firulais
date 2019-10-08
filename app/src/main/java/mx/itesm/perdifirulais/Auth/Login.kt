package mx.itesm.perdifirulais.Auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import mx.itesm.perdifirulais.R
import mx.itesm.perdifirulais.Seleccion


class Login : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegistro.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        mAuth = FirebaseAuth.getInstance()

        btnIngresar.setOnClickListener {
            manejarLogin()
        }
    }

    private fun manejarLogin() {
        val mail = etMail.text.toString()
        val password = etPassword.text.toString()
        if (mail.isBlank() || password.isBlank()) {
            Toast.makeText(
                this, "Falta llenar alguno de los campos.",
                Toast.LENGTH_SHORT
            ).show()
        }
        login(mail, password)
    }

    private fun login(mail: String, password: String) {
        mAuth.signInWithEmailAndPassword(mail, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("_Login", "signInWithEmail:success")
                    startActivity(Intent(this, Seleccion::class.java))

                } else {
                    Toast.makeText(
                        this, "No se pudo iniciar sesion. ${task.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
