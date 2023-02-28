package com.example.newapp29feb.viewmodel

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp29feb.databse.Api
import com.example.newapp29feb.databse.DatabaseEntity
import kotlinx.coroutines.launch

class OverViewModel :
 ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<List<DatabaseEntity>>()

    // The external immutable LiveData for the response String
    val response: LiveData<List<DatabaseEntity>>
        get() = _response

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getDetailsFromApi()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    // Now the Retrofit API service is running, but it uses a callback with two callback methods that you had to implement.
    // One method handles success and another handles failure, and the failure result reports exceptions.

//    private fun  getPosts() {
//       PostApi.retrofitService.getPosts().enqueue(
//            object: Callback<List<Posts>> {
//                override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
//                    Log.i("response",response.toString())
//                 _response.value=response.body()
//                }
//
//                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
//                    Log.e("error","$t")
//                }
//
//            })
//    }

    // using  coroutines with exception handling, instead of using callbacks.
    private fun getDetailsFromApi() {
        viewModelScope.launch {
            try {
                val listResult = Api.retrofitService.getItems()
                _response.value = listResult
                // Log.i("size", listResult.size.toString())
            } catch (e: Exception) {
                //  _response.value = "Failure: ${e.message}"
            }

        }
    }
}