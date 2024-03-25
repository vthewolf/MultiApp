package com.example.cursoaristidevs.androidmaster.syntaxis

fun main() {
    val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(weekDays[0])
    println(weekDays.size)

    //Tamaños
    if (weekDays.size >=8) {
        println(weekDays[7])
    } else {
        println("No hay mas valores en el array")
    }

    // Modificar valores
    weekDays[0] = "Feliz lunes"
    println(weekDays[0])

    // Bucles para arrays
    for (position in weekDays.indices){
        println(weekDays[position])
    }

    for ((position, value) in weekDays.withIndex()) {
        println("La posición $position contiene $value")
    }

    for (weekDay in weekDays) {
        println("Ahora es $weekDay")
    }
}