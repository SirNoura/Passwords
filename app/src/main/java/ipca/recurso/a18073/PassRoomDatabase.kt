package ipca.recurso.a18073

import android.content.Context
import androidx.room.*

class PassRoomDatabase {

    @Database(entities = arrayOf(managePassword::class), version = 1, exportSchema = false)
    public abstract class PassRoomDatabase : RoomDatabase() {

        abstract fun passDao(): PassDao

        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: PassRoomDatabase? = null

            fun getDatabase(context: Context): PassRoomDatabase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        PassRoomDatabase::class.java,
                        "Pass_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}