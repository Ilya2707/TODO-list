package View

import Model.DescriptionViewModel
import Model.OrderViewModel
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.R
import com.example.mytodolist.databinding.TodoListFragmentBinding
import java.time.ZoneId
import java.time.format.FormatStyle
import java.util.Locale

class TodoListFragment : Fragment(R.layout.todo_list_fragment) {
    private val descriptionViewModel: DescriptionViewModel by activityViewModels()
    private val sharedViewModel: OrderViewModel by lazy {
        val activity = requireNotNull(this.activity) {
        }
        ViewModelProvider(this, OrderViewModel.ViewModelFactory(activity.application)).get(
            OrderViewModel::class.java
        )
    }
    private lateinit var binding: TodoListFragmentBinding
    private lateinit var adapter: TodoListAdapter



    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = TodoListFragmentBinding.bind(view)

        //val buttonAdd: Button = view.findViewById(R.id.buttonAdd)
        val temp = binding.temp
        val desc = binding.descriptionTV
        val recyclerView: RecyclerView = binding.recyclerV
        adapter = TodoListAdapter(clickItem = {
            descriptionViewModel.setDescriptionTodo(it)
            findNavController().navigate(R.id.action_todoListFragment_to_description)
        },
            clickCheckBox = { sharedViewModel.changeTodo(it) },
            clickButtonDelete = { sharedViewModel.deleteTodo(it) })

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        sharedViewModel.getTodo().observe(viewLifecycleOwner, Observer {
            adapter.list = it
        })
        sharedViewModel.getForeCast().observe(viewLifecycleOwner) { currentWeather ->
            binding.dateTV.text =
                java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(
                    Locale.FRANCE
                ).withZone(ZoneId.systemDefault())
                    .format(java.time.Instant.ofEpochSecond(currentWeather.dt))
            binding.City.text = currentWeather.name
            binding.humidity.text = "${currentWeather.main.humidity} %"
            val kelvinToCelsius = Math.ceil(currentWeather.main.temp - 273.15).toInt()
            if (kelvinToCelsius >= 0) {
                temp.text = "+${kelvinToCelsius}⁰ С"
            } else {
                temp.text = "-${kelvinToCelsius}⁰ С"
            }

            val feelsLikeKelvinToCelsius = Math.ceil(currentWeather.main.feelsLike - 273.15).toInt()
            if (feelsLikeKelvinToCelsius >= 0) {
                binding.fillsLikeTemp.text = "+${feelsLikeKelvinToCelsius}⁰ С"
            } else {
                binding.fillsLikeTemp.text = "-${feelsLikeKelvinToCelsius}⁰ С"
            }
            binding.descriptionTV.text = currentWeather.weatherList[0].description

            when (currentWeather.weatherList[0].icon) {
                "01d" -> binding.imageWeather.setImageResource(R.mipmap.d01)
                "02d" -> binding.imageWeather.setImageResource(R.mipmap.d02)
                "03d" -> binding.imageWeather.setImageResource(R.mipmap.d03)
                "04d" -> binding.imageWeather.setImageResource(R.mipmap.d04)
                "09d" -> binding.imageWeather.setImageResource(R.mipmap.d09)
                "10d" -> binding.imageWeather.setImageResource(R.mipmap.d10)
                "11d" -> binding.imageWeather.setImageResource(R.mipmap.d11)
                "13d" -> binding.imageWeather.setImageResource(R.mipmap.d13)
                "50d" -> binding.imageWeather.setImageResource(R.mipmap.d50)
                "01n" -> binding.imageWeather.setImageResource(R.mipmap.n01)
                "02n" -> binding.imageWeather.setImageResource(R.mipmap.n02)
                "03n" -> binding.imageWeather.setImageResource(R.mipmap.n03)
                "04n" -> binding.imageWeather.setImageResource(R.mipmap.n04)
                "09n" -> binding.imageWeather.setImageResource(R.mipmap.n09)
                "10n" -> binding.imageWeather.setImageResource(R.mipmap.n10)
                "11n" -> binding.imageWeather.setImageResource(R.mipmap.n11)
                "13n" -> binding.imageWeather.setImageResource(R.mipmap.n13)
                "50n" -> binding.imageWeather.setImageResource(R.mipmap.n50)
            }
        }


        binding.buttonAdd.setOnClickListener() {
            //(activity as MainActivity).navController.navigate(R.id.action_listFragment_to_noteText2)
            findNavController().navigate(R.id.action_todoListFragment_to_addTodoItemFragment)
        }





    }
}















