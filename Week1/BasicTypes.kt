fun main(args: Array<String>): Unit {

    /* Val - Var difference */

    val val1 = 123
    // val1 = 246 <- Val value cannot be reassigned
    var var1 = 123
    println(var1)
    var1 = 256
    println(var1)

    /* Basic Data Types */

    val a: Int = 100 //32 bits
    val d: Double = 100.00 //64 bits
    val f: Float = 100.00f //32 bits
    val l: Long = 2000000004 //64 bits
    val s: Short = 10 //16 bits
    val b: Byte = 1 // 8 bits


    /* Strings and prints */

    val letter: Char
    letter = 'A'
    val var2 = "Long string"
    print(letter) // print function doesn't provide automatic end of line
    print(letter + "\n")
    println(var2)

    println("$var2 $letter") // $ sign useful for printing variables inside the string

    val bool1: Boolean
    bool1 = true
    println(bool1.toString() + " " + (!bool1).toString())

}
