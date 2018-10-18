fun main(args: Array<String>) {

    var a: String = "Hello World!"
    // a = null -> Will give error

    var b: String? = "Hello World!"
    b = null
    println(b)

    // val length = b.length -> will give error that b can be null

    /* Checking nulls */
    val length = if (b != null) b.length else -1

    val c = "Kotlin"
    if (c != null && c.length > 0) // If c is not val then this can be dangerous check
        println("Length of string is ${c.length}")
    else
        println("Empty string")

    /* Safe call (checking)*/
    val d = "Kotlin"
    val e: String? = null
    println(d?.length)
    println(e?.length)

    // you can chain the null checks
    // universe?.galaxy?.starSystem?.planet?.name
    // If any of them is null then result will be null too

    val nullList: List<Int?> = listOf(2, null, 5)

    for ((i, v) in nullList.withIndex())
        println("index:$i value:$v")

    for (v in nullList)
        v?.let { println(it) } // null value will be ignored

    /* Elvis operator */
    var z: String? = "Kotlin"
    val l = if (z != null) z.length else -1 // We don't need to write so many code instead we will use elvis
    var m: Int = z?.length ?: -1

    /* Safe cast */
    val safeVal: Int? = z as Int // This line will throw ClassCastException because it's wrong casting resulting with null
    val safeVal2: Int? = z as? Int // This is safe casting
    println("value:$safeVal2")


}

fun try1() {
    var z: String? = null
    // If you are in love with NullPointerException Kotlin does love you too
    var n = z?.length ?: throw NullPointerException("z is null")
}

fun try2() {
    val z: String? = null
    val str = z!! // We indicate that z has to be not null. If it is null than nullpointexception will be thrown
}