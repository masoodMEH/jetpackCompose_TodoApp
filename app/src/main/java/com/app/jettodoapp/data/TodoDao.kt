package com.app.jettodoapp.data

import androidx.room.*
import com.app.jettodoapp.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("Select * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("Select * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM TODO_TABLE")
    suspend fun deleteAllTasks()

    @Query(
        "Select * from todo_table " +
                "WHERE title Like :searchQuery" +
                " OR description" +
                " Like :searchQuery"
    )
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query(
        "Select * from todo_table order by case " +
                "when priority like 'L%'" +
                " then 1 when priority like 'M%'" +
                " then 2 when priority like 'H%' " +
                "then 3 END "
    )
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query(
        "Select * from todo_table order by case " +
                "when priority like 'H%'" +
                " then 1 when priority like 'M%'" +
                " then 2 when priority like 'L%' " +
                "then 3 END "
    )
    fun sortByHighPriority(): Flow<List<ToDoTask>>


}