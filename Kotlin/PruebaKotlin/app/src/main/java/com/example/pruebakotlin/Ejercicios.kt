package com.example.pruebakotlin

fun main()
{
    println("Ejercicios 2, 3, 4, 5, 6, 7 y 8.")
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
        else -> println("No válido")
    }
}   //var Hola = Hola(21,"")




//***** 2. Notificaciones móviles *****
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



//***** 3. Precio de la entrada de cine *****
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



//***** 4. Conversor de temperatura *****
fun Ejercicio4()
{
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}





//***** 5. Catálogo de canciones *****
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




//***** 6. Perfil de Internet *****
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




//***** 7. Teléfonos plegables *****
fun Ejercicio7()
{
    val phone = FoldablePhone(true)
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.unfold()
    phone.checkPhoneScreenLight()
}
open class Phone(var isScreenLightOn:Boolean = false)
{
    open fun switchOn() { isScreenLightOn = true }
    fun switchOff() { isScreenLightOn = false }
    fun checkPhoneScreenLight()
    {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
class FoldablePhone(var isFolded:Boolean) : Phone()
{
    override fun switchOn()
    {
        if (!isFolded) isScreenLightOn = true
    }
    fun fold() { isFolded = true }
    fun unfold() { isFolded = false }
}




//***** Subasta especial *****
fun Ejercicio8()
{
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int
{
    return bid?.amount ?: minimumPrice

    /*if (bid != null)
    {
        if (bid.amount > minimumPrice)
            return bid.amount
        else
            return minimumPrice
    }
    else
        return minimumPrice*/
}



