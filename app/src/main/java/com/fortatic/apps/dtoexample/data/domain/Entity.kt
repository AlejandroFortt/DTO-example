package com.fortatic.apps.dtoexample.data.domain

import com.fortatic.apps.dtoexample.utils.smartTruncate

data class Posts(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {
    val shortBody: String
        get() = body.smartTruncate(100)
}

data class Comments(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)