package com.home.data.entity

data class CommentEntity(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)