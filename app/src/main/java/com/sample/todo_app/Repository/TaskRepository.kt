package com.sample.todo_app.Repository

import android.app.appsearch.SearchResult
import android.app.appsearch.StorageInfo
import androidx.room.Query
import com.sample.todo_app.Database.TaskDatabase
import com.sample.todo_app.Model.Task

class TaskRepository(private val db:TaskDatabase) {

    suspend fun insertTask(task:Task) = db.getTaskDao().insertTask(task)
    suspend fun deletTask(task:Task) = db.getTaskDao().deleteTask(task)
    suspend fun updateTask(task:Task) = db.getTaskDao().updateTask(task)

    fun getAllTask() = db.getTaskDao().getAllTasks()
    fun searchTask(query: String?) = db.getTaskDao().searchTaskByTitleOrDesc(query)
}