package com.example.guesstheword24.dependencies

interface Factory<T> {
    fun create() : T
}