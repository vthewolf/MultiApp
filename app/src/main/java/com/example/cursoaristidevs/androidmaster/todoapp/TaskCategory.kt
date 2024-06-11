package com.example.cursoaristidevs.androidmaster.todoapp

sealed class TaskCategory {
    data object Personal: TaskCategory()
    data object Business: TaskCategory()
    data object Other: TaskCategory()
}