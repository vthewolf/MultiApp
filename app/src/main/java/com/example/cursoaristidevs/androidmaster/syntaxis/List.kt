package com.example.cursoaristidevs.androidmaster.syntaxis

fun main(){
    mutableList()
}

fun mutableList(){
    val weekDays: MutableList<String> = mutableListOf(
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado",
        "Domingo")

    weekDays.add(0, "AristiDay")
    println(weekDays)

    if (weekDays.isEmpty()) {
        // No pinto nada porque no hay
    } else {
        weekDays.forEach { println(it) }
    }

    if (weekDays.isNotEmpty()){
        weekDays.forEach { println(it) }
    }

    weekDays.last()
}

fun inmutableList(){
    val readOnly: List<String> = listOf(
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado",
        "Domingo")

    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    //Filtrar
    val example = readOnly.filter { it.contains("a") }
    println(example)

    readOnly.forEach { weekDay -> println(weekDay) }
}