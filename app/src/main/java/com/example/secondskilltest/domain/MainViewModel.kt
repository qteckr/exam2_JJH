package com.example.secondskilltest.domain

import com.example.secondskilltest.data.MainRepository

class MainViewModel {
    private val repository by lazy { MainRepository() }
}