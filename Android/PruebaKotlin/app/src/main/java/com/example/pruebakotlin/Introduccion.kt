package com.example.pruebakotlin

import java.time.LocalDate
import java.time.Year

fun main()
{
    println("Ejercicios 2, 3, 4, 5, 6, 7, 8, 9, 10.")
    print("Elije uno: ")

    val stringInput = readLine()!!
    println()

    when (stringInput.toInt())
    {
        2 -> Ejercicio2()
        3 -> Ejercicio3()
        4 -> Ejercicio4()
        5 -> Ejercicio5()
        6 -> Ejercicio6()
        7 -> Ejercicio7()
        8 -> Ejercicio8()
        9 -> Ejercicio9()
        10 -> Ejercicio10()
        else -> println("No válido")
    }
}   //var Hola = Hola(21,"")




fun Ejercicio2()
{
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages<100)
        println("You have $numberOfMessages notifications.")
    else
        println("Your phone is blowing up! You have 99+ notifications.")
}



fun Ejercicio3()
{
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    when(age)
    {
        in 1..12 -> return 12
        in 13..60 -> {if (isMonday) return 25 else return 30}
        in 61..100 -> return 20
        else -> return -1
    }
}



fun Ejercicio4()
{
    /*
    De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
    Kelvin a Celsius: °C = K - 273.15
    De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
    */
    //printFinalTemperature(27,"C","F",)
    //printFinalTemperature(350,"K","C",)
    //printFinalTemperature(10,"F","K",)
}
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}




fun Ejercicio5()
{
    var Song1 = Song("Made in Heaven", "Queen", 1991, 50000)
    Song1.printDesc()
}
class Song(val title:String, val artist:String, val releaseYear:Int, var replays:Int)
{
    var popular:Boolean
    init {
        if (replays<1000)   popular = false;
        else                popular = true;
    }
    fun printDesc() { println("$title, interpretada por $artist, se lanzó en $releaseYear") }
}




fun Ejercicio6()
{
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?)
{
    fun showProfile()
    {
        println("Name: $name")
        println("Age: $age")
        print("Likes to $hobby.")
        if (referrer==null)
            println(" Doesn't have a referrer.\n")
        else
            println(" Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.\n")
    }
}




fun Ejercicio7()
{
    //
}



fun Ejercicio8()
{
    //
}



fun Ejercicio9()
{
    //
}



fun Ejercicio10()
{
    //
}


