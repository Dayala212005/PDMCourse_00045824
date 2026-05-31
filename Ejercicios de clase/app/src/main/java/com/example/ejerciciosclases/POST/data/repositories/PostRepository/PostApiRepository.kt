package com.example.ejerciciosclases.POST.data.repositories.PostRepository
import com.example.ejerciciosclases.POST.data.api.KtorClient
import com.example.ejerciciosclases.POST.data.api.Post.CreatePostRequestDto
import com.example.ejerciciosclases.POST.data.api.Post.PostDTO
import com.example.ejerciciosclases.POST.data.api.Post.PostPostResponseDTO
import com.example.ejerciciosclases.POST.data.api.Post.toModel
import com.example.ejerciciosclases.POST.model.Post
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType


class PostApiRepository: IPostRepository {
    override suspend fun getPosts(): Result<List<Post>> {
        try {
            val response: List<PostDTO> = KtorClient.client.get("/posts") {
            }.body()

            return Result.success(response.map { postDto -> postDto.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun createPost(
        title: String,
        body: String,
    ): Result<PostPostResponseDTO> {
        try {
            val request = CreatePostRequestDto(
                title = title,
                body = body,
                userId = 1,
            )
            val response: PostPostResponseDTO = KtorClient.client.post("https://jsonplaceholder.typicode.com/posts") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }.body()

            return Result.success(response)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}