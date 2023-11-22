package es.unex.giis.asee.gepeto.data

object Session {
    private var data = HashMap<String, Any>()

    fun getValue(key: String): Any? {
<<<<<<< HEAD
        return data[key]    }
=======
        return data[key]
    }
>>>>>>> 3d4a9574852490036a2989aa5871ebb439bbf660

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