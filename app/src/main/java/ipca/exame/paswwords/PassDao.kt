package ipca.exame.paswwords

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PassDao {
    @Query("SELECT * from tbl_pass ORDER BY strPass ASC")
    fun getAlphabetizedWords(): LiveData<List<Pass>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pass: Pass)

    @Query("DELETE FROM tbl_pass")
    fun deleteAll()
}