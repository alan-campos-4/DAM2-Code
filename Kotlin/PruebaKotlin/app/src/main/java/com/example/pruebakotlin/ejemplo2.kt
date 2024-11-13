package com.example.pruebakotlin

var edad:Int = 44

fun main()
{
    ejercutaLamba(saludar)
    ejercutaLamba2(saludaNombre2)
    ejercutaLamba2("Felix", saludaNombre)
    ejecutarLambda3(sumarVeinte)
    ejecutarLambda4(sumar,24,8)
    ejecutarLambda4({ a:Int, b:Int -> a+b },24,8)
}

val saludar : () -> Unit = { println("Hola Mundo") }
fun ejercutaLamba(function:()->Unit)
{
    function()
}

val saludaNombre : (String) -> Unit  = { name:String -> println("Hola $name") }
val saludaNombre2 : (String) -> Unit  = { println("Hola $it") }
fun ejercutaLamba2(function:(a:String)->Unit)
{
    function("Felix")
}
fun ejercutaLamba2(n:String, function:(a:String)->Unit)
{
    function(n)
}

val sumarVeinte:(Int) -> Int = {it+20}
fun ejecutarLambda3(pepe:(Int)->Int)
{
    println(pepe(7))
}

val sumar:(Int, Int) -> Int = { a:Int, b:Int -> a+b }
fun ejecutarLambda4(function:(Int,Int)->Int, x:Int, y:Int)
{
    println( function(x,y) )
}

