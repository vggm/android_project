package es.unex.giis.asee.gepeto.data.api

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
import com.google.gson.annotations.SerializedName

data class Equipment(
    @SerializedName("name"  ) var name  : String,
    @SerializedName("image" ) var image : String
)
<<<<<<< HEAD
=======
=======
data class Equipment(
    val id: Int,
    val image: String,
    val name: String,
    val temperature: Temperature
)
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6
