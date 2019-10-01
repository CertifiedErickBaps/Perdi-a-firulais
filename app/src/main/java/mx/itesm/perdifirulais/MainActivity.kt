package mx.itesm.perdifirulais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import androidx.annotation.NonNull
import android.R.attr.password
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
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
            if(etUsuario.toString().isEmpty() || etContraseña.toString().isEmpty()){
                return@setOnClickListener
            }
            else{
                val textUsuario = findViewById<View>(R.id.etUsuario) as TextInputEditText
                val valueUsuario = textUsuario.text.toString()
                val textContraseña = findViewById<View>(R.id.etContraseña) as TextInputEditText
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
