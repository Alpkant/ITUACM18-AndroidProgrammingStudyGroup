fun main(args: Array<String>) {

    val a = 6
    val b = 6
    if (a > b) {
        println(a)
    } else
        println(b)

    val max = if (a > b) a else b

    /* When */
    when (a) {
        5 -> println("a is 5")
        6 -> println("a is 6")
        7, 8, 9 -> println("a can be 7,8,9")
        else -> {
            println("a is neither 5 nor 6")
        }

    }

    /* For Loops */
    val items = listOf(1, 2, 3, 4)
    for (i in items) {
        println(i)
    }

    for ((index, value) in items.withIndex()) {
        println("index: $index value: $value")
    }

    /* While loops */
    var x = 5
    while (x <= 10) {
        println(x)
        x++
    }
    x = 5

    do {
        println(x)
        x++
    } while (x <= 10)

    /* Ranges */
    for (i in 0..4)
        println(i)

    for (i in 4 downTo -1)
        println(i)

    for (i in 1..4 step 2)
        println(i)

    for (i in 1 until 5) {
        // i in [1, 5), 10 is excluded
        println(i)
    }
}