package com.mony.viewmodelsample.ui.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    // Observable property
    private var _currentCount = MutableLiveData(0)
    // Backer property
    val currentCount: LiveData<Int>
        get() = _currentCount

    init {
        Log.d("meow", "CounterViewModel created")
    }

    fun incrementCount(){
        _currentCount.value = (_currentCount.value)?.inc()
    }

    fun resetCount() {
        _currentCount.value = (_currentCount.value)?.times(0)
    }
}