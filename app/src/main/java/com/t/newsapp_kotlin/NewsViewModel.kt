package com.t.newsapp_kotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Json
import com.squareup.moshi.ToJson
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * The [ViewModel] that is attached to the [NewsHomeFragment].
 */
class NewsViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

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

        _response.value = NewsApi.retrofitService.getProperties().enqueue(
            object : Callback<NewsData> {
                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                    //Log.i("response", t.message)
                }

                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    _response.value = response.body().toString()
                }
            }).toString()
    }
}