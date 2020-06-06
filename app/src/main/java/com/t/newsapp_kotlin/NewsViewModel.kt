package com.t.newsapp_kotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Json
import com.squareup.moshi.ToJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.*

/**
 * The [ViewModel] that is attached to the [NewsHomeFragment].
 */
class NewsViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    //private val _response = MutableLiveData<String>()

    private var _response = MutableLiveData<String>() // watch here could be Article too

    val response: LiveData<String>
        get() = _response

    //New declaration to receive response
    private val _property = MutableLiveData<Article>()

    val property: LiveData<Article>
        get() = _property



    //New declaration to receive response
    private val _articleList = MutableLiveData<List<Article>>()

    val articleList: LiveData<List<Article>>
        get() = _articleList


    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    /**
     * Call getNewsData() on init so we can display status immediately.
     */
    init {
        getNewsData()
    }

    /**
     * Sets the value of the status LiveData to the News API status.
     */
    private fun getNewsData() {

        coroutineScope.launch {
            var getPropertiesDeferred = NewsApi.retrofitService.getProperties()

            try {
                var listResult = getPropertiesDeferred.await()

                _response.value = "Success: ${listResult.articles} News Items"
                //_property.value = listResult //this returns an article

                _articleList.value = listResult.articles //this returns an article
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}