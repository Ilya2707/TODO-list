package View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import Model.OrderViewModel
import com.example.mytodolist.R

class TodoListFragment : Fragment() {
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonAdd: Button = view.findViewById(R.id.buttonAdd)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerV)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        sharedViewModel.getTodo().observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = TodoListAdapter(it)
        })

        buttonAdd.setOnClickListener() {
            (activity as MainActivity).navController.navigate(R.id.action_listFragment_to_noteText2)
        }

    }


}









