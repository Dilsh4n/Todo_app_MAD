package com.sample.todo_app.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sample.todo_app.Model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("select * from Task order by id desc")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE taskTitle LIKE '%' || :query || '%' OR taskDesc LIKE '%' || :query || '%'")
    fun searchTaskByTitleOrDesc(query: String?):LiveData<List<Task>>
}