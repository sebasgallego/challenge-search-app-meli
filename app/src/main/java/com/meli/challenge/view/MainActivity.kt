package com.meli.challenge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.meli.challenge.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Actividad principal de la aplicación.
 *
 * Esta clase actúa como el punto de entrada de la aplicación y gestiona la navegación entre fragmentos.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState El estado previamente guardado de la actividad, si lo hay.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el diseño de la actividad.
        setContentView(R.layout.activity_main)

        // Encuentra el fragmento de host de navegación en la vista.
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Obtiene el controlador de navegación asociado al fragmento de host.
        val navController = navHostFragment.navController

        // Configura la barra de acción para que utilice el controlador de navegación.
        setupActionBarWithNavController(navController)

        // Configura Timber para el registro de registros.
        setupTimberLog()
    }

    /**
     * Método llamado cuando se presiona el botón de navegación de la barra de acción.
     *
     * @return `true` si la navegación fue manejada, `false` de lo contrario.
     */
    override fun onSupportNavigateUp(): Boolean {
        // Obtiene el controlador de navegación asociado al fragmento de host y realiza la navegación hacia atrás.
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /**
     * Configura Timber para el registro de registros en modo de depuración.
     */
    private fun setupTimberLog() {
        // Configura Timber para el registro de registros en modo de depuración.
        Timber.plant(Timber.DebugTree())
    }
}
