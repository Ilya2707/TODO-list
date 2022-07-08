package View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import Model.NavResultDispatcher
import com.example.mytodolist.R

class TodoListAdapter(
    private val list: List<ToDoItem>
) : RecyclerView.Adapter<TodoListAdapter.ItemViewHolder>() {

    private val onClickListener: (item: ToDoItem) -> Unit = { item ->
        NavResultDispatcher.sendNavResult("CHANGE_TODO_ITEM", item)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: ItemViewHolder, position: Int
    ) {
        val todo: ToDoItem = list[position]
        viewHolder.textView.text = todo.title
        if (todo.isChecked) {
            viewHolder.checkB.toggle()
        }
        viewHolder.checkB.setOnClickListener {
            onClickListener.invoke(list[position])
        }
    }

    override fun getItemCount() = list.size
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tV1)
        val checkB: CheckBox = view.findViewById(R.id.chB1)

    }
}