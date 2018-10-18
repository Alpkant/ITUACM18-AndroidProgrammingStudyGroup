fun main(args: Array<String>): Unit {

    /* Val - Var difference */

    val val1 = 123
    // val1 = 246 <- Val value cannot be assigned
    var var1 = 123
    println(var1)
    var1 = 256
    println(var1)

    /* Basic Data Types */

    val a: Int = 100 //32 bit
    val d: Double = 100.00 //64 bit
    val f: Float = 100.00f //32 bit
    val l: Long = 2000000004 //64 bit
    val s: Short = 10 //16 bit
    val b: Byte = 1 // 8


    /* Strings and prints */

    val letter: Char
    letter = 'A'
    val var2 = "Long string"
    print(letter) // Print function doesn't provide automatic end of line
    print(letter + "\n")
    println(var2)

    println("$var2 $letter") // $ sign useful for printing variables inside the string

    val bool1: Boolean
    bool1 = true
    println(bool1.toString() + " " + (!bool1).toString())

}
