package com.example.ejerciciosclases.POST.screens.ViewPost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejerciciosclases.POST.data.repositories.PostRepository.IPostRepository
import com.example.ejerciciosclases.POST.data.repositories.PostRepository.PostApiRepository
import com.example.ejerciciosclases.POST.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewPostViewModel: ViewModel() {

    private val postRepository: IPostRepository = PostApiRepository()
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            _loading.value = true
            postRepository.getPosts()
                .onSuccess { posts ->
                    _posts.value = posts
                    _error.value = null
                }
                .onFailure { error ->
                    _error.value = error.message
                }
            _loading.value = false
        }
    }
}