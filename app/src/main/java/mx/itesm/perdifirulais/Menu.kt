package mx.itesm.perdifirulais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.perdifirulais.ui.menu.MenuFragment

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MenuFragment.newInstance())
                .commitNow()
        }
    }

}
