package Model

import View.ToDoItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DescriptionViewModel: ViewModel() {

    private  val _descriptionTodo = MutableLiveData<ToDoItem>()

    fun setDescriptionTodo(desTodo: ToDoItem) {
        _descriptionTodo.value = desTodo
    }

    fun getDescription(): MutableLiveData<ToDoItem> {
        return _descriptionTodo
    }

    override fun onCleared() {
        super.onCleared()
    }
}