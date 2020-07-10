package ipca.exame.paswwords

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PassRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<Pass>>

    init {
        val passdDao = WordRoomDatabase.getDatabase(application, viewModelScope).passDao()
        repository = PassRepository(passdDao)
        allWords = repository.allWords
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(pass: Pass) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(pass)
    }
}