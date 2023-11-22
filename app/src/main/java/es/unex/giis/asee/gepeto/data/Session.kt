package es.unex.giis.asee.gepeto.data

object Session {
    private var data = HashMap<String, Any>()

    fun getValue(key: String): Any? {
<<<<<<< HEAD
        return data[key]    }
=======
<<<<<<< HEAD
        return data[key]    }
=======
        return data[key]
    }
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660
>>>>>>> b93cd7764f434cc36895631760398a9f614255f6

    fun setValue(key: String, value: Any) {
        data[key] = value
    }

    fun removeValue(key: String) {
        data.remove(key)
    }

    fun clear() {
        data.clear()
    }
}