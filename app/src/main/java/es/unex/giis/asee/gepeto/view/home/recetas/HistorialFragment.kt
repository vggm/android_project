package es.unex.giis.asee.gepeto.view.home.recetas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import es.unex.giis.asee.gepeto.adapters.RecetasAdapter
import es.unex.giis.asee.gepeto.data.Session
import es.unex.giis.asee.gepeto.database.GepetoDatabase
import es.unex.giis.asee.gepeto.databinding.FragmentHistorialBinding
import es.unex.giis.asee.gepeto.model.Receta
import es.unex.giis.asee.gepeto.model.User
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
    private lateinit var adapter: RecetasAdapter

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

    override fun onResume() {
        super.onResume()
        loadRecetasFromDB()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        loadRecetasFromDB()
    }

    private fun loadRecetasFromDB() {
        lifecycleScope.launch {
            val user = Session.getValue("user") as User
            recetas = db.recetaDao().getUserConRecetas(user.userId!!).recetas
            if ( recetas.isEmpty() ) {
                Toast.makeText(context, "No hay recetas en la base de datos", Toast.LENGTH_SHORT).show()
            }
            adapter.updateData(recetas)
            binding.spinner.visibility = View.GONE
        }
    }

    private fun setUpRecyclerView() {
        adapter = RecetasAdapter(recetas = emptyList(),
            onClick = {
                listener.onRecetaClick(it)
            },
            onLongClick = {
                setRecetaFav(it)
            }
            , context = context
        )
        with(binding) {
            rvHistorialList.layoutManager = LinearLayoutManager(context)
            rvHistorialList.adapter = adapter
        }
    }

    private fun setRecetaFav(receta: Receta) {

        if (receta.favorita) return

        lifecycleScope.launch {
            receta.favorita = !receta.favorita
            db.recetaDao().update(receta)
            loadRecetasFromDB()
            Toast.makeText(context, "Receta añadida a favoritos!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // avoid memory leaks
    }
}