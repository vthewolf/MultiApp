package com.example.cursoaristidevs.exercises

/**
  En el codigo inicial que se proporcina en el siguiente fragmento de código,
  escribe un programa que calcule los precios de estas entradas basados en la edad.

 - Un precio de entrada infantil de USD 15 para personas de 12 años o menos
 - Un precio de entrada estandar de USD 30 para personas entre 13 y 60 años. Los lunes
  un precio con descuento de USD 25 para el mismo grupo.
 - Un precio para adultos mayores de USD 20 para personas con 61 años o más. (asumiendo
  que la edad máxima es 100)
 - Un valor de -1 para indicar que el precio no es válido cuando un usuario ingresa una
  edad fuera de las limitaciones.

 RESULTADO:
 - The movie ticket price for a person aged 5 is $15.
 - The movie ticket price for a person aged 28 is $25.
 - The movie ticket price for a person aged 87 is $20.
 */

fun main(){
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean) : Int {
    return when (age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}