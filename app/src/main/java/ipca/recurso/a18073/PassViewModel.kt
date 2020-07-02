package ipca.recurso.a18073

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassViewModelViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PassRepository

    val allPassw: LiveData<List<managePassword>>

    init {
        val passdDao = PassRoomDatabase.PassRoomDatabase.getDatabase(application).passDao()
        repository = PassRepository(passdDao)
        allPassw = repository.allPass
    }

    fun insert(pass: managePassword) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(pass)
    }
}