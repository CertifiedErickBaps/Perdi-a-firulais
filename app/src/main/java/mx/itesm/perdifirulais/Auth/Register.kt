package mx.itesm.perdifirulais.Auth

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import mx.itesm.perdifirulais.R

class Register : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        manejarTerminos()
        manejarRegistro()


    }

    fun manejarInfo(){
        TODO()
    }
    fun manejarTerminos() {

        checkboxTerminosyCondiciones.setOnClickListener {
            if (checkboxTerminosyCondiciones.isChecked) {
                !checkboxTerminosyCondiciones.isChecked
                return@setOnClickListener
            } else {
                checkboxTerminosyCondiciones.isChecked
                return@setOnClickListener
            }
        }
    }

    fun manejarRegistro() {

        btnIngresarRegistro.setOnClickListener {
            if (etUser.text.toString().isBlank() || etMail.text.toString().isBlank() || etPassword.text.toString().isBlank() || etRPassword.text.toString().isBlank()) {

                Toast.makeText(
                    this, "Falta llenar alguno de los campos.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else if (etPassword.text.toString() != etRPassword.text.toString()) {
                Toast.makeText(
                    this, "Las contrasenas no coinciden.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else if (checkboxTerminosyCondiciones.isChecked == false) {
                Toast.makeText(
                    this, "No se han aceptado los terminos y condiciones.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else {
                mAuth.createUserWithEmailAndPassword(
                    etMail.text.toString(),
                    etPassword.text.toString()
                )
                    .addOnCompleteListener(
                        this
                    ) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("_Register", "createUserWithEmail:success")
                            val user = mAuth.currentUser

                        } else {
                            // If sign in fails, display a message to the user.

                            Log.d("_Register", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                this, "El registro fallo. ${task.exception}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

            }


        }

    }
}
