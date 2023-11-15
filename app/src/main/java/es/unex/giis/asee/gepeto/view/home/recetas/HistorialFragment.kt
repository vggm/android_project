package es.unex.giis.asee.gepeto.view.home.recetas

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import es.unex.giis.asee.gepeto.adapters.HistorialAdapter
import es.unex.giis.asee.gepeto.api.APIError
import es.unex.giis.asee.gepeto.api.getNetworkService
import es.unex.giis.asee.gepeto.data.api.Recipes
import es.unex.giis.asee.gepeto.data.toRecipe
import es.unex.giis.asee.gepeto.database.GepetoDatabase
import es.unex.giis.asee.gepeto.databinding.FragmentHistorialBinding
import es.unex.giis.asee.gepeto.model.Receta
import kotlinx.coroutines.launch


class HistorialFragment : Fragment() {

    private var recetas: List<Receta> = emptyList()
    private lateinit var db: GepetoDatabase

    private lateinit var listener: OnRecetaClickListener
    interface OnRecetaClickListener {
        fun onRecetaClick(receta: Receta)
    }

    private var _binding: FragmentHistorialBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: HistorialAdapter

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        db = GepetoDatabase.getInstance(context)!!
        if (context is OnRecetaClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnShowClickListener")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHistorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        obtenerRecetasFromDB()
        setUpRecyclerView()
    }

    private fun obtenerRecetasFromDB() {
        lifecycleScope.launch {

            recetas = db.recetaDao().getUserConRecetas(1).recetas ?: emptyList()
            if ( recetas.isEmpty() ) {
                Toast.makeText(context, "No hay recetas en la base de datos", Toast.LENGTH_SHORT).show()
            }
            adapter.updateData(recetas)
            binding.spinner.visibility = View.GONE

        }
    }

    private fun setUpRecyclerView() {
        adapter = HistorialAdapter(recetas = recetas, onClick = {
            listener.onRecetaClick(it)
        },
            onLongClick = {
                Toast.makeText(context, "long click on: "+it.nombre, Toast.LENGTH_SHORT).show()
            }
            , context = context
        )
        with(binding) {
            rvHistorialList.layoutManager = LinearLayoutManager(context)
            rvHistorialList.adapter = adapter
        }
        android.util.Log.d("RecetasFragment", "setUpRecyclerView")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // avoid memory leaks
    }
}