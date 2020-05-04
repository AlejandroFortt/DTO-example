package com.fortatic.apps.dtoexample.data.network

import com.fortatic.apps.dtoexample.data.domain.Comments

//DTO Posts
data class NetworkPosts(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)


//DTO Comments
data class NetworkComments(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

fun List<NetworkComments>.toDomainModel(): List<Comments> {
    return map { response ->
        Comments(
            postId = response.postId,
            id = response.id,
            name = response.name,
            email = response.email,
            body = response.body
        )
    }.orEmpty()
}
