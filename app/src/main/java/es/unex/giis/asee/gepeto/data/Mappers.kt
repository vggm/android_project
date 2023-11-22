package es.unex.giis.asee.gepeto.data

import es.unex.giis.asee.gepeto.R
<<<<<<< HEAD
import es.unex.giis.asee.gepeto.data.api.Equipments
=======
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
import es.unex.giis.asee.gepeto.data.api.Ingredient
import es.unex.giis.asee.gepeto.data.api.RecipesItem
import es.unex.giis.asee.gepeto.data.api.StepsItem
import es.unex.giis.asee.gepeto.model.Ingrediente
<<<<<<< HEAD

fun RecipesItem.toRecipe() = Receta(
    recetaId = id,
    nombre = title ,
    descripcion = "",
    favorita = false,
    ingredientes = (usedIngredients.map { it.name } + missedIngredients.map { it.name }).joinToString (separator = ";"),
    equipamientos = "",
    imagen = R.drawable.ejemplo_plato,
    imagenPath = image
)

fun Ingredient.toIngredients() = Ingrediente(
    nombre = strIngredient ?: "",
)

fun StepsItem.toRecipe() = Pasos (
    descripcion = steps.map { it.step },
)

fun Equipments.toEquipamiento() = Equipamiento (
    descripcion = equipment.map { it.name },
=======
import es.unex.giis.asee.gepeto.model.Pasos
import es.unex.giis.asee.gepeto.model.Receta

fun RecipesItem.toShowRecipe() = Receta(
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
    idReceta = id.toString(),
    nombre = title ?: "",
    descripcion = emptyList(),
    favorita = false,
    //apend de usedIngredients, missedIngredients, unusedIngredients
    ingredientes = usedIngredients.map { it.name } + missedIngredients.map { it.name },
    equipamientos = emptyList(),
    imagen = R.drawable.plato_ejemplo,
    imagenPath = image ?: ""
)

fun Ingredient.toShowIngredients() = Ingrediente(
    nombre = strIngredient ?: "",
)

fun StepsItem.toShowRecipe() = Pasos (
    descripcion = steps.map { it.step},
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
)