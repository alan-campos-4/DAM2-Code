package com.example.pruebakotlin

fun main()
{
    /*
    var edad:Int = 44
    val d:Double = 44.478965
    val f:Float = 24.7f
    val l:Long = 120000000000
    //val cannot be reassigned
    edad = 45

    val c:Char = 'a'
    val s:String = "Huelva"
    val b:Boolean = true

    println(edad.toString()+d.toString())
    println("Hola soy Félix y mi edad es de $edad y vivo en $s")
    println(suma2(5,3))
    println(sumaAdd(85))
    */
    val mes:Int = 5
    println(mes)
    println(month(mes))
    println(trimester(mes))
    println(semester(mes))

    multipleType(4)
    multipleType("lol")
    multipleType(true)

    var nombre:String? = "Alan"
    nombre = null
    if (nombre=="Alan") {println("Hola")}
    println(nombre?.get(0) ?: "Es nulo")

    val numeros = arrayOf(1,2,3,4,5,6,7,8,9,10)
    println(numeros)
    println(numeros[0])
    println(numeros.size)
    for (valor in numeros)
        println(valor)
    for (posicion in numeros.indices)
        println(posicion)
    for ((pos,value) in numeros.withIndex())
        println("Posicion $pos: valor $value")


}




fun suma1(x:Int, y:Int):Int  {return x+y}
fun suma2(x:Int, y:Int) = x+y
fun sumaAdd(x:Int, y:Int=10) = x+y  //If y is not introduced, it equals 10

fun month(m:Int) =
    when (m) {
        1 -> "Enero"
        2 -> "Febrero"
        3 -> "Marzo"
        4 -> "Abril"
        5 -> "Mayo"
        6 -> "Junio"
        7 -> "Julio"
        8 -> "Agosto"
        9 -> "Septiembre"
        10 -> "Octubre"
        11 -> "Noviembre"
        12 -> "Diciembre"
        else -> "No válido"
    }
fun trimester(m:Int) =
    when (m) {
        in 1..3 -> "Primer trimestre"
        in 4..6 -> "Segundo trimestre"
        in 7..9 -> "Tercero trimestre"
        in 10..12 -> "Cuarto trimestre"
        else -> "No válido"
    }
fun semester(m:Int) =
    when (m) {
        in 1..6 -> "Primer semestre"
        in 7..12 -> "Segundo semestre"
        else -> "No válido"
    }

fun multipleType(value:Any)
{
    when (value)
    {
        is Int -> println(value*2)
        is String -> println("La cadena es $value")
        is Boolean -> if (value) println("Verdadero")
    }
}




