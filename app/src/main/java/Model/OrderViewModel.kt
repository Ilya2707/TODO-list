package Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import View.ToDoItem

class OrderViewModel : ViewModel(), NavResultDispatcher.Listener {

    private val _todo = MutableLiveData<List<ToDoItem>>(listOf())

    init {
        NavResultDispatcher.addListener(this)
    }

    override fun onCleared() {
        NavResultDispatcher.removeListener(this)
        super.onCleared()
    }

    override fun onNavResult(key: String, argument: Any?) {
        if (key == "ADD_TODO_ITEM") {
            val nextTodo = argument as ToDoItem
        }
    }

    fun setTodo(nextTodo: ToDoItem) {
        NavResultDispatcher.sendNavResult("ADD_TODO_ITEM", nextTodo)
        _todo.update { items -> items + nextTodo }
    }

    fun getTodo(): MutableLiveData<List<ToDoItem>> {
        return _todo
    }

    override fun changeNavResult(key: String, argument: Any?) {
        if (key == "CHANGE_TODO_ITEM") {
            val nextTodo = argument as ToDoItem
            _todo.value?.forEach { it ->
                if (it.title == nextTodo.title) {
                    it.isChecked = it.isChecked == false
                }
            }
        }
    }

    fun <T> MutableLiveData<T>.update(block: (T) -> T) {
        val oldValue = value ?: return
        val newValue = block.invoke(oldValue)
        value = newValue
    }
}

