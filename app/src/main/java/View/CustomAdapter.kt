package View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import Model.NavResultDispatcher
import android.widget.Button
import com.example.mytodolist.R

class TodoListAdapter(
    private val clickItem: (item: ToDoItem) -> Unit,
    private val clickCheckBox: (item: ToDoItem) -> Unit,
    private val clickButtonDelete: (item: ToDoItem) -> Unit

) : RecyclerView.Adapter<TodoListAdapter.ItemViewHolder>() {
    var list: List<ToDoItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
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
        viewHolder.checkB.setChecked(todo.isChecked)

        viewHolder.checkB.setOnClickListener {
            var curentIsChecked: ToDoItem = list[position]
            curentIsChecked.isChecked = viewHolder.checkB.isChecked
            clickCheckBox(curentIsChecked)
        }


        viewHolder.buttonDel.setOnClickListener {
            clickButtonDelete(list[position])
        }


        viewHolder.itemView.setOnClickListener{
            clickItem(list[position])
        }


    }

    override fun getItemCount() = list.size
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tV1)
        val checkB: CheckBox = view.findViewById(R.id.chB1)
        val buttonDel: Button = view.findViewById(R.id.buttonDelete)

    }
}