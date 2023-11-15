package es.unex.giis.asee.gepeto.data

import es.unex.giis.asee.gepeto.R
import es.unex.giis.asee.gepeto.data.api.Ingredient
import es.unex.giis.asee.gepeto.data.api.RecipesItem
import es.unex.giis.asee.gepeto.data.api.StepsItem
import es.unex.giis.asee.gepeto.model.Ingrediente
import es.unex.giis.asee.gepeto.model.Pasos
import es.unex.giis.asee.gepeto.model.Receta

fun RecipesItem.toRecipe() = Receta(
    /*
    val idReceta: String,
    val nombre: String,
    val descripcion: String,
    var favorita: Boolean,
    val ingredientes: List<String> = emptyList(),
    val equipamientos: List<String> = emptyList(),
    val imagen: Int,
    val imagenPath: String
     */
    recetaId = id,
    nombre = title ?: "",
    descripcion = "",
    favorita = false,
    //apend de usedIngredients, missedIngredients, unusedIngredients
    ingredientes = (usedIngredients.map { it.name } + missedIngredients.map { it.name }).joinToString (separator = ";"),
    equipamientos = "",
    imagen = R.drawable.plato_ejemplo,
    imagenPath = image ?: ""
)

fun Ingredient.toIngredients() = Ingrediente(
    nombre = strIngredient ?: "",
)

fun StepsItem.toRecipe() = Pasos (
    descripcion = steps.map { it.step },
)