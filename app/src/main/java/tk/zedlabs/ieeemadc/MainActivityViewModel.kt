package tk.zedlabs.ieeemadc

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import tk.zedlabs.ieeemadc.model.Data
import tk.zedlabs.ieeemadc.model.Status


class MainActivityViewModel : ViewModel() {

    private val repository: Repository = Repository()
    private val token = "2f4876c59bc813aac5703b6e7694e4ac6d9edc6f"

    val data : LiveData<Status> = liveData(Dispatchers.IO) {
        val retrievedData = repository.getData(token)
        emit(retrievedData)
    }

}