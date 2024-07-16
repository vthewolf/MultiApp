package com.example.cursoaristidevs.androidmaster.todoapp

sealed class TaskCategory(var isSelected: Boolean = true) {
    data object Personal: TaskCategory()
    data object Business: TaskCategory()
    data object Other: TaskCategory()
}