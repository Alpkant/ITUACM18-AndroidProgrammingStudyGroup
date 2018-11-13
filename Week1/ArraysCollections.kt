fun main(args: Array<String>) {

    val numbers = intArrayOf(1, 3, 5, 7) // This is in the int[] type
    println(numbers.javaClass.kotlin) // Type of the array
    // intArray is not recommended to use. Use Array<Int> in most cases

    val numberArray: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6) // This is in the Array<Int> type
    println(numberArray.javaClass.kotlin)

    println(numberArray[0])
    //println("index 0 numberArray[0] ") -> will produce wrong behaviour
    println("index 0 : $numberArray[0] ")
    //println(numberArray[-1]) -> will produce out of bounds exception
    println("index 0 : ${numberArray.get(0)} ")


    /* Collections */

    var mutable1: MutableList<Int> = mutableListOf(1, 2, 2, 4, 5)
    var immutable1: List<Int> = listOf(1, 2, 2, 4, 5)
    println("Mutable list " + mutable1.toString())
    mutable1.add(12)
    println("Mutable list " + mutable1.toString())
    mutable1.remove(1)
    mutable1.first()
    mutable1.last()
    mutable1.clear()

    /** Note that val or var is different than mutability */
    immutable1 = mutable1.toList()
    // Will not give error because we defined as variable so any list can be assigned to immutable1 variabe
    // But assigning mutablelist to immutable is not allowed. Use toList function to convert mutable to immutable

    /* Set */
    // Set doesn't allow duplicate but list does

    var set1: Set<Int> = setOf(2, 2, 5, 7, 2, 9)
    var set2: MutableSet<Int> = mutableSetOf(2, 2, 4)
    println(set1.toString())
    // println(set1.get(2)) // There is no get method
    // because Sets are not ordered but lists are ordered

    /* Map */
    var map1: Map<Int, String> = mapOf(6 to "Ankara", 35 to "İzmir", 34 to "Istanbul")
    var map2: MutableMap<Int, String> = mutableMapOf(6 to "Ankara", 35 to "İzmir", 34 to "Istanbul")
    println(map1.get(34)) // Print Istanbul
    map2.put(6, "Tokat") // Overrides the current value
    println(map2[6])
    
    var list_a = mutableListOf (1,2,6)
    var list_b = mutableListOf (1,5,2)
    //Method below assigns reference 
    // Both lists will be same object
    list_b = list_a
    list_a[0] = 6
    println(list_b)
  


}
