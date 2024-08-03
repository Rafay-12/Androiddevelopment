package com.example.destination.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.destination.data.model.Destination
import com.example.destination.repository.DestinationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DestinationViewModel(application: Application) : AndroidViewModel(application) {
    private val destinationRepository = DestinationRepository(application)
    private val _destinations = MutableLiveData<List<Destination>>()
    val destinations: LiveData<List<Destination>> get() = _destinations
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        fetchDestinations()
    }

    private fun fetchDestinations() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    destinationRepository.getDestinations()
                }
                _destinations.postValue(result)
                Log.d("DestinationViewModel", "Result size: ${result.size}")
            } catch (e: Exception) {
                Log.e("DestinationViewModel", "Exception: ${e.message}")
                _error.postValue(e.message)
            }
        }
    }
}