package com.example.ejerciciosclases.POST.screens.ViewCreatePost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejerciciosclases.POST.data.repositories.PostRepository.IPostRepository
import com.example.ejerciciosclases.POST.data.repositories.PostRepository.PostApiRepository
import com.example.ejerciciosclases.POST.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CreatePostViewModel: ViewModel() {
    private val postRepository: IPostRepository = PostApiRepository()

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()
    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private val _saving = MutableStateFlow(false)
    val saving = _saving.asStateFlow()

    private val _saveMessage = MutableStateFlow<String?>(null)
    val saveMessage = _saveMessage.asStateFlow()

    fun savePost(title: String, body: String) {
        viewModelScope.launch {
            _loading.value = true
            postRepository.createPost(title, body)
                .onSuccess {
                    _saveMessage.value = "Post creado con ID ${it.id}"
                }
                .onFailure { error ->
                    _error.value = error.message
                }
            _loading.value = false
        }
    }

}