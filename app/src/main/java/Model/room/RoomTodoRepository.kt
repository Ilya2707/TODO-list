package Model.room

import Model.room.entities.TodoDbEntity
import Model.room.entities.asTodoItem
import View.ToDoItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomTodoRepository(private  val todoDatabase: AppDatabase) {
    private val todoDbEntityList = todoDatabase.todoDao().getTodo()

     val todolist: LiveData<List<ToDoItem>> = todoDbEntityList.map {
         it.asTodoItem()
     }

    suspend fun addTodo(item: ToDoItem) {
        withContext(Dispatchers.IO) {
            todoDatabase.todoDao().insertTodo(TodoDbEntity.fromTodoItem(item))
        }
    }

    suspend fun updateTodoItem(item: ToDoItem) {
        withContext(Dispatchers.IO) {
            todoDatabase.todoDao().updateTodo(TodoDbEntity.fromTodoItem(item))
        }
    }

    suspend fun deleteTodoItem(item: ToDoItem) {
        withContext(Dispatchers.IO) {
            todoDatabase.todoDao().deleteTodo(TodoDbEntity.fromTodoItem(item))
        }
    }
}