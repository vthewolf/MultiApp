package com.example.multiapp.todoapp

sealed class TaskCategory(var isSelected: Boolean = true) {
    data object Personal: TaskCategory()
    data object Business: TaskCategory()
    data object Other: TaskCategory()
}