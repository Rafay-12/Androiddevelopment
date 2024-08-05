package com.example.database.main.repository


import androidx.lifecycle.LiveData
import com.example.database.main.data.dao.UserDao
import com.example.database.main.data.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = runBlocking {
        withContext(Dispatchers.IO)
        {
            userDao.getAllUserData()
        }
    }
    
    fun insert(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
        }
    }

}