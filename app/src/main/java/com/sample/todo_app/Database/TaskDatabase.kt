package com.sample.todo_app.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sample.todo_app.Model.Task

@Database(entities = [Task::class], version = 1)
abstract  class TaskDatabase:RoomDatabase() {
    abstract fun getTaskDao() : TaskDao
    companion object{
        @Volatile
        private var instance : TaskDatabase ? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                "task_db"
            ).build()


    }
}