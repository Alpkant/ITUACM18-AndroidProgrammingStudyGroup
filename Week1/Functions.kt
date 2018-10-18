fun main(args: Array<String>) {
    var a = 6
    var b = 8
    var sum = sumTwoInt(a, b)
    println("sum:$sum a=$a b=$b")

    sum = multDefaultArg(a)
    println("sum:$sum a=$a")

    sum = multDefaultArg(b=2,a=4) // Function with named arguments
    println("sum:$sum ")

    fun avg(a: Double, b: Double) = (a + b) / 2

    sumOfNumbers(123,321,412,12) // pass as many as values you want
    val array = intArrayOf(123,321,412,12)
    sumOfNumbers(*array) // Spread operator (*)

}

fun sumTwoInt(a: Int, b: Int): Int {
    //a++ -> Arguments are from val type so reassigning is not possible

    return a + b
}

/* Function with default argument */
fun multDefaultArg(a: Int, b: Int = 5): Int {
    return a * b
}

/* Unit returning function */
fun printNumber(a: Int): Unit {
    println("number is $a")
}

/* Varargs */
fun sumOfNumbers(vararg numbers: Int) : Unit{
    var sum = 0
    for (i in numbers){
        sum += i
    }
    println("Sum: $sum")
}