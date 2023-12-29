package Model.room

import Model.room.entities.TodoDbEntity
import android.app.Application
import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [TodoDbEntity::class],
    version = 4,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 3, to = 4, spec = AppDatabase.MyAutoMigration::class)],
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    @DeleteColumn(tableName = "todo_list", columnName = "id")
    class MyAutoMigration : AutoMigrationSpec
}

private lateinit var INSTANCE: AppDatabase

fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "db"
            ).build()
        }
    }
    return INSTANCE
}