package View

import Model.DescriptionViewModel
import Model.NavResultDispatcher
import Model.NavResultDispatcher.Listener
import Model.OrderViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.mytodolist.R
import com.example.mytodolist.databinding.DescriptionTodoBinding

class Description : Fragment(R.layout.description_todo) {

    private val sharedViewModel: DescriptionViewModel by activityViewModels()
    private lateinit var binding: DescriptionTodoBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DescriptionTodoBinding.bind(view)
        sharedViewModel.getDescription().observe(viewLifecycleOwner, Observer {
            binding.nameTodo.text = it.title
            binding.descriptionT.text = it.description
        })


    }

}