package com.fortatic.apps.dtoexample.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
private const val PATH_POSTS = "posts"
private const val PATH_COMMENTS = "comments"

interface ApiService {
    @GET(PATH_POSTS)
    fun getPostsAsync(): Deferred<List<NetworkPosts>>

    @GET(PATH_COMMENTS)
    fun getCommentsAsync(): Deferred<List<NetworkComments>>
}

object Api {

    private val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(
            ApiService::class.java)
    }
}