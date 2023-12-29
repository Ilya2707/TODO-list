package Model

import Model.network.CurrentWeather
import Model.network.WeatherApi
import Model.network.currentCoord
import Model.room.RoomTodoRepository
import Model.room.getDatabase
import View.ToDoItem
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class OrderViewModel(application: Application) : AndroidViewModel(application) {
    private val roomTodoRepository = RoomTodoRepository(getDatabase(application))
    val todolist = roomTodoRepository.todolist
    private val currentWeather = MutableLiveData<CurrentWeather>()



    fun setTodo(item: ToDoItem) {
        viewModelScope.launch {
            roomTodoRepository.addTodo(item)
        }
    }


    fun getTodo(): LiveData<List<ToDoItem>> {
        return todolist
    }


    fun changeTodo(item: ToDoItem) {
        viewModelScope.launch {
            roomTodoRepository.updateTodoItem(item)
        }
    }

    fun deleteTodo(item: ToDoItem) {
        viewModelScope.launch {
            roomTodoRepository.deleteTodoItem(item)
        }
    }

    fun requestForeCast(coord: currentCoord) {
        Log.e("coord","lat: ${coord.lat}, lon: ${coord.lon}")
        viewModelScope.launch {
            try {
                currentWeather.value = WeatherApi.retrofitService.getCurrentWeather(coord.lat, coord.lon)
            }
            catch (e: Exception) {
                Log.e("NetworkError","NetworkError $e")
            }
        }
    }

    fun getForeCast(): MutableLiveData<CurrentWeather> {
        return currentWeather
    }

    fun <T> MutableLiveData<T>.update(block: (T) -> T) {
        val oldValue = value ?: return
        val newValue = block.invoke(oldValue)
        value = newValue
    }

    class ViewModelFactory(
        val app: Application
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(OrderViewModel::class.java)) {
                return OrderViewModel(app) as T
            } else {
                throw IllegalStateException("Unknown view model class")
            }
        }
    }
}

