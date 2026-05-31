package com.example.ejerciciosclases.POST.data.repositories.PostRepository

import com.example.ejerciciosclases.POST.data.api.Post.PostDTO
import com.example.ejerciciosclases.POST.data.api.Post.PostPostResponseDTO
import com.example.ejerciciosclases.POST.model.Post

interface IPostRepository {
    suspend fun getPosts(): Result<List<Post>>
    suspend fun createPost(title: String, body: String,): Result<PostPostResponseDTO>
}