fun main(args: Array<String>){
    //example1()
    //example2()
    example3()

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