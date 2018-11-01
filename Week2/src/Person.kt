class Person(var phoneNumber: String, private var name: String, protected val surName: String )//Primary Constructor
{
    /* Secondary Constructors
       Cannot use with primary one
    constructor(name: String ){
        this.name = name
    }
    constructor(phoneNumber:String){
        this.phoneNumber = phoneNumber
    }
    */

    // Secondary Constructors can be used with initializing call
    constructor(name: String): this("",name,"")
    // Constructor without arguments.
    constructor(): this("","","")

    //Init call is invoked every time an object is created.
    init {
        println("A person is created. Name is $name $surName")
    }

    fun printPerson(){
        println("Person: $name $surName phone number: $phoneNumber (Class method is used.)")
    }

    // Overriding toString method gives the advantage to use println() function.
    override fun toString(): String {
        return "Person: $name $surName phone number: $phoneNumber"
    }

    fun printAge(){
        println("$name $surName at the age of: $AGE")
    }
    // Static attributes, methods are written in the  block below.
    companion object {
        val AGE = 15
    }
}