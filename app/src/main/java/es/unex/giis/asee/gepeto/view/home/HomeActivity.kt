package es.unex.giis.asee.gepeto.view.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import android.widget.Toast
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import es.unex.giis.asee.gepeto.R
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
import es.unex.giis.asee.gepeto.data.Session


import es.unex.giis.asee.gepeto.databinding.ActivityHomeBinding
<<<<<<< HEAD
=======
=======

import es.unex.giis.asee.gepeto.model.User
import es.unex.giis.asee.gepeto.view.home.recetas.FavoritasFragment
import es.unex.giis.asee.gepeto.view.home.recetas.HistorialFragment
import es.unex.giis.asee.gepeto.databinding.ActivityHomeBinding
import es.unex.giis.asee.gepeto.model.Receta
import es.unex.giis.asee.gepeto.view.home.recetas.RecetasFragment
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6

import es.unex.giis.asee.gepeto.view.home.recetas.RecetasFragmentDirections
import java.util.TreeSet

class HomeActivity :
<<<<<<< HEAD
    AppCompatActivity() {
=======
<<<<<<< HEAD
    AppCompatActivity() {
=======
    AppCompatActivity(),
    HistorialFragment.OnRecetaClickListener,
    FavoritasFragment.OnReceta2ClickListener,
    IngredientesFragment.OnCrearRecetaListener,
    ObservacionesFragment.OnGenerarRecetaListener {
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }


    companion object {
        const val USER_INFO = "USER_INFO"
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        fun start( context: Context, user: User ) {
            val intent = Intent(context, HomeActivity::class.java).apply {
                putExtra(USER_INFO, user)
            }
            context.startActivity(intent)
        }
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
        setUpUI()
    }

    private fun setUpUI() {
<<<<<<< HEAD
=======
=======
        val user = intent.getSerializableExtra(USER_INFO) as User

        setUpUI(user)
    }

    fun setUpUI(user: User) {
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
        binding.bottomNavigation.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.recetasFragment,
                R.id.listaFragment,
                R.id.ingredientesFragment,
                R.id.equipamientoFragment
            )
        )

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Hide toolbar and bottom navigation when in detail fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if ((destination.id == R.id.recetaDetailFragment) or
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
                (destination.id == R.id.observacionesFragment) or
                (destination.id == R.id.settingsFragment)){
//                binding.toolbar.menu.clear()
                binding.bottomNavigation.visibility = View.GONE
            } else {
<<<<<<< HEAD
=======
=======
                (destination.id == R.id.observacionesFragment)){
                //   binding.toolbar.visibility = View.GONE
                binding.toolbar.menu.clear()
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//        val searchItem = menu?.findItem(R.id.action_search)
//        val searchView = searchItem?.actionView as SearchView

>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
        // Configure the search info and add any event listeners.
        return super.onCreateOptionsMenu(menu)
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
    fun mostrarLupaAppbar ( mostrar: Boolean ) {
        val searchView = binding.toolbar.menu.findItem(R.id.action_search)
        if (searchView != null)
            searchView.isVisible = mostrar
    }
<<<<<<< HEAD
=======
=======
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            // User chooses the "Settings" item. Show the app settings UI.
<<<<<<< HEAD
            val action = RecetasFragmentDirections.actionHomeToSettingsFragment()
            navController.navigate(action)
=======
<<<<<<< HEAD
            val action = RecetasFragmentDirections.actionHomeToSettingsFragment()
            navController.navigate(action)
=======
            Toast.makeText(this, "Settings option", Toast.LENGTH_SHORT).show()
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
            true
        }

        else -> {
            // The user's action isn't recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6

    override fun onDestroy() {
        super.onDestroy()
        Session.clear() // Clear session on logout
<<<<<<< HEAD
=======
=======
    override fun onRecetaClick(receta: Receta) {
        val action = RecetasFragmentDirections.actionRecetasFragmentToRecetaDetailFragment(receta)
        navController.navigate(action)
    }

    override fun onReceta2Click(receta: Receta) {
        val action = RecetasFragmentDirections.actionRecetasFragmentToRecetaDetailFragment(receta)
        navController.navigate(action)
    }

    override fun onCrearRecetaClick(ingredientes: TreeSet<String>) {
        val action = IngredientesFragmentDirections
            .actionIngredientesFragmentToObservacionesFragment(
                ingredientes.joinToString(separator = ", ", prefix = "", postfix = ".")
            )
        navController.navigate(action)
    }

    override fun onGenerarRecetaClick(receta: Receta) {
        val action = ObservacionesFragmentDirections
            .actionObservacionesFragmentToRecetaDetailFragment(receta)
        navController.navigate(action)
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
    }
}


