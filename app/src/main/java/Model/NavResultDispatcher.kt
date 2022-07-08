package Model

import androidx.annotation.MainThread

object NavResultDispatcher {

    private val listeners = mutableListOf<Listener>()

    @MainThread
    fun addListener(listener: Listener) {
        listeners.add(listener)
    }

    @MainThread
    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    @MainThread
    fun sendNavResult(key: String, argument: Any? = null) {
        listeners.forEach { listener ->
            listener.onNavResult(key, argument)
            listener.changeNavResult(key, argument)
        }
    }

    interface Listener {
        fun onNavResult(key: String, argument: Any? = null)
        fun changeNavResult(key: String, argument: Any? = null)
    }
}