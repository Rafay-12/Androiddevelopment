package com.example.database.main.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.database.main.data.database.UserDatabase
import com.example.database.main.data.model.User
import com.example.database.main.repository.UserRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository
    val allUsers: LiveData<List<User>>

    init {
        Log.d("UserViewModel","Initializing View Model")
        val userDao = UserDatabase.getInstance(application)?.userDao()
        repository = userDao?.let { UserRepository(it) }!!
        allUsers = repository.allUsers
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
}