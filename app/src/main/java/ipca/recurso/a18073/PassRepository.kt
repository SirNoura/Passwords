package ipca.recurso.a18073

import androidx.lifecycle.LiveData

class PassRepository(private val passdDao: PassDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allPass: LiveData<List<managePassword>> = passdDao.getAlphabetizedPass()

    suspend fun insert(pass: managePassword) {
        passdDao.insert(pass)
    }
}