package View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.*
import Model.NavResultDispatcher
import Model.OrderViewModel
import com.example.mytodolist.R


class AddTodoItemFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_todo_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val saveButton: Button = view.findViewById(R.id.btnSaveText)
        val editText: EditText = view.findViewById(R.id.etText)
        saveButton.setOnClickListener() {
            var toDoItem: ToDoItem = ToDoItem(editText.getText().toString(), false)
            sharedViewModel.setTodo(toDoItem)
            NavResultDispatcher.sendNavResult("ADD_TODO_ITEM", toDoItem)
            (activity as MainActivity).navController.navigate(R.id.action_noteText_to_listFragment)
        }
    }
}





