package com.sample.todo_app.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.sample.todo_app.Model.Task
import com.sample.todo_app.Repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(app : Application, private val taskRepository: TaskRepository ):AndroidViewModel(app){

    fun addTask(task: Task) =
        viewModelScope.launch {
            taskRepository.insertTask(task)
        }

    fun deleteTask(task: Task) =
        viewModelScope.launch {
            taskRepository.deletTask(task)
        }

    fun updateTask(task: Task) =
        viewModelScope.launch {
            taskRepository.updateTask(task)
        }

    fun getAllTasks() = taskRepository.getAllTask()

    fun searchTask(query: String?) =
        taskRepository.searchTask(query)

}