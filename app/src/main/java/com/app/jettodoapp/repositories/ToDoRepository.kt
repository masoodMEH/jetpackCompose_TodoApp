package com.app.jettodoapp.repositories

import com.app.jettodoapp.data.TodoDao
import com.app.jettodoapp.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val todoDao: TodoDao) {
    val getAllTasks: Flow<List<ToDoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return todoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        todoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        todoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        todoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTask(toDoTask: ToDoTask) {
        todoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return todoDao.searchDatabase(searchQuery = searchQuery)
    }

}