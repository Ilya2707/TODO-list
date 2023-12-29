package Model.room

import Model.room.entities.TodoDbEntity
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {

    @Query("SELECT *FROM todo_list")
    fun getTodo(): LiveData<List<TodoDbEntity>>

    @Update(entity = TodoDbEntity::class)
    fun updateTodo(todoDbEntity: TodoDbEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todoDbEntity: TodoDbEntity)

    @Delete
    fun deleteTodo(todoDbEntity: TodoDbEntity)
}