fun main(args: Array<String>){
    example1()
    example2()
    example3()
    example4()
    example5()

}

fun example1(){
    /* This example focus on class attributes
        Used file: Person.kt
     */

    //                  Creating person objects.
    //Using primary constructor
    val person1 = Person("05431736161","Burak","Bekci")
    // Using secondary constructor with 1 parameter.
    val person2 = Person("Alperen")
    // Using constructor with no argument.
    val person3 = Person()
    // val person4 = Person("05431736161","Burak") -> Gives error. No constructor is defined with 2 parameter.

    // In kotlin '=' operation can be used for both assignment and reading.
    println("We declared phone number attribute as public. We can access it from here. Phone number person1: ${person1.phoneNumber}") // Reading operation
    person1.phoneNumber = "+90123125334" // Assignment operation
    println("We declared phone number attribute as public. We can access it from here. Phone number person1: ${person1.phoneNumber}") // Reading operation

    //  Below attributes are not allowed to reach from here.
    //person1.name -> Private
    //person1.surName -> Protected.

    person1.printPerson()
    // Below function will print meaningful things now (after override).
    println(person1)
    // Using static attributes.
    person1.printAge()
    person2.printAge()
}

fun example2(){
    /*
        This example focuses on inheritance.
        Used files: Animsal.kt, Cat.kt, Fish.kat
     */
    val cat = Cat("Boncuk")
    cat.printAnimal()
    cat.saySomething()
    val fish = Fish("Hamsi")
    fish.printAnimal()
    fish.saySomething()
    fish.printProtected()
}

fun example3(){
    /*
     Main topic on this example is Interfaces.
     See Mother.kt, Child.kt and ChildMotherInterface.kt
     */
    //Creating objects.
    val child = Child("Alperen")
    val mother = Mother(child)
    //Setting interface objects.
    mother.setInterface()
    println("Plane has came to airport. Our child will get on soon.")
    //First event occurs.
    child.getOnPlane()
    println("Plane has landed.")
    //Second event occurs
    child.getOffFromPlane("Istanbul")
}
fun example4(){
    /*
    Main topic of this example is high order functions.
    Calculator.kt is the source code.
    */
    val cal = Calculator(80,16,1)
    val cal1 = Calculator(80,16,2)
    val cal2 = Calculator(80,16,3)
    val cal3 = Calculator(80,16,0)
}

fun example5(){
    /*
     Using built-in lambda functions.
     see Film.kt file.
     */


    // Define a lambda.
    val func = {println("\nHi I am a function\n")}
    // Invoke it.
    func()

    println("\nPrinting a list with forEach")
    val numberList = mutableListOf<Int>(1,3,6,1,62,4)
    numberList.forEachIndexed { index, i -> println("Number on $index is $i") }

    val filmList = mutableListOf(Film("AB",3.2f),Film("asa",1.1f),Film("AA",9.1f),Film("V",8.1f))

    println("\nSorting a film list in increasing order by score")
    filmList.sortBy { it.score }
    filmList.forEach { println("${it.name}: ${it.score}") }

    println("\nSorting a film list in decreasing order by score")
    filmList.sortByDescending { it.score }
    filmList.forEach { println(it.toString()) }

    println("\nFiltering a list")
    val filteredList = filmList.filter { it.name == "AB" }

    filteredList.forEach { println(it.toString()) }

}