package mx.itesm.perdifirulais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import android.view.View
import com.google.android.material.textfield.TextInputEditText


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
                val textUsuario = findViewById<View>(R.id.etMail) as TextInputEditText
                val valueUsuario = textUsuario.text.toString()
                val textContraseña = findViewById<View>(R.id.etPassword) as TextInputEditText
                val valueContraseña = textContraseña.text.toString()
                Log.d("Email", valueUsuario)

               mAuth.createUserWithEmailAndPassword(valueUsuario, valueContraseña)
                    .addOnCompleteListener(this
                            ) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Wakanda", "createUserWithEmail:success")
                                val user = mAuth.currentUser
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.d("Wakanda", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            }
                }
            }
        }
    }



}
