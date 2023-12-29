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
import androidx.navigation.fragment.findNavController
import com.example.mytodolist.R
import com.example.mytodolist.databinding.AddTodoItemFragmentBinding


class AddTodoItemFragment : Fragment(R.layout.add_todo_item_fragment) {



    private val sharedViewModel: OrderViewModel by activityViewModels()
    private lateinit var binding: AddTodoItemFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding = AddTodoItemFragmentBinding.bind(view)
        //val saveButton: Button = view.findViewById(R.id.btnSaveText)
        //val editText: EditText = view.findViewById(R.id.etText)
            binding.btnSaveText.setOnClickListener() {
            val toDoItem = ToDoItem(binding.etText.getText().toString(), false, binding.etTextD.getText().toString())
            sharedViewModel.setTodo(toDoItem)
            //(activity as MainActivity).navController.navigate(R.id.action_noteText_to_listFragment)
                findNavController().navigate(R.id.action_addTodoItemFragment_to_todoListFragment)
        }
    }
}






