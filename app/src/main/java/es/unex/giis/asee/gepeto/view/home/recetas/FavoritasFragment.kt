package es.unex.giis.asee.gepeto.view.home.recetas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import es.unex.giis.asee.gepeto.adapters.FavoritasAdapter
import es.unex.giis.asee.gepeto.databinding.FragmentFavoritasBinding
import es.unex.giis.asee.gepeto.model.Receta

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritasFragment : Fragment() {
    private lateinit var listener: OnReceta2ClickListener
    interface OnReceta2ClickListener {
        fun onReceta2Click(receta: Receta)
    }

    private var _binding: FragmentFavoritasBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FavoritasAdapter

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        if (context is OnReceta2ClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnShowClickListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        adapter = FavoritasAdapter(recetas = emptyList(), onClick = {
            listener.onReceta2Click(it)
        },
            onLongClick = {
                Toast.makeText(context, "long click on: "+it.nombre, Toast.LENGTH_SHORT).show()
            }
        )
        with(binding) {
            rvFavoritasList.layoutManager = LinearLayoutManager(context)
            rvFavoritasList.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // avoid memory leaks
    }
}