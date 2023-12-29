package Model.room.entities

import View.ToDoItem
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "todo_list"
)
data class TodoDbEntity(
    @PrimaryKey val tittle: String,
    @ColumnInfo(name = "is_checked") val isChecked: Boolean,
    val description: String
) {

       companion object{ fun fromTodoItem (item: ToDoItem): TodoDbEntity = TodoDbEntity(
            tittle = item.title,
            isChecked = item.isChecked,
            description = item.description
        )
       }
}

//fun TodoDbEntity.toDomain() : ToDoItem { TODO()
//}

fun List<TodoDbEntity>.asTodoItem(): List<ToDoItem> = map {
    ToDoItem(
        title = it.tittle,
        isChecked = it.isChecked,
        description = it.description
    )
}