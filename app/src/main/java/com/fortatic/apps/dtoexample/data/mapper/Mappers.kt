package com.fortatic.apps.dtoexample.data.mapper

import com.fortatic.apps.dtoexample.data.domain.Posts
import com.fortatic.apps.dtoexample.data.network.Api
import com.fortatic.apps.dtoexample.data.network.NetworkPosts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PostsDataMapper {
    fun transform(responses: List<NetworkPosts>?) = responses?.map { response ->
        Posts(
            userId = response.userId,
            id = response.id,
            title = response.title,
            body = response.body
        )
    }.orEmpty()
}