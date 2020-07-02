package ipca.recurso.a18073
import androidx.lifecycle.LiveData
import androidx.room.*


data class managePassword(val word: String){
    @Entity(tableName = "tblPass")
    class managePassword(

        @PrimaryKey(autoGenerate = true) val id: Int,
        var password : String,
        var site : String,
        var descricao : String ,
        var data : String

    )
}

@Dao
interface PassDao {

    @Query("SELECT * from tblPass ORDER BY id ASC")

    fun getAlphabetizedPass(): LiveData<List<managePassword>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pass: managePassword)

    @Query("DELETE FROM tblPass")
    suspend fun deleteAll()
}