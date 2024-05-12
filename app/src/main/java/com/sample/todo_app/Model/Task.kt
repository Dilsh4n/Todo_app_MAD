package com.sample.todo_app.Model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity(tableName = "Task")
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val taskTitle:String,
    val taskDesc : String,
//    val taskDate : Date,
//    val taskTime :Date
):Parcelable
