package com.fortatic.apps.dtoexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fortatic.apps.dtoexample.data.domain.Comments
import com.fortatic.apps.dtoexample.data.domain.Posts
import com.fortatic.apps.dtoexample.data.mapper.PostsDataMapper
import com.fortatic.apps.dtoexample.data.network.Api
import com.fortatic.apps.dtoexample.data.network.toDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val _coments = MutableLiveData<List<Comments>>()
    val coments: LiveData<List<Comments>>
        get() = _coments

    private val _posts = MutableLiveData<List<Posts>>()
    val posts: LiveData<List<Posts>>
        get() = _posts

    init {
        Timber.i("MainViewModel has created")
        getCommentsFromNetwork()
        getPostsFromNetwork()
    }

    private fun getCommentsFromNetwork() = viewModelScope.launch {
        try {
            Timber.i("init getCommentsFromNetwork")
            val defCommentList = Api.retrofitService.getCommentsAsync().await().toDomainModel()
            _coments.postValue(defCommentList)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun getPostsFromNetwork() = viewModelScope.launch {
        try {
            Timber.i("init getPostsFromNetwork")
            val defPostsList = Api.retrofitService.getPostsAsync().await()
            _posts.value = PostsDataMapper.transform(defPostsList)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }
}