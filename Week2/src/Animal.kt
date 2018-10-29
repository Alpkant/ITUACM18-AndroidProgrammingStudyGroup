// A class need to be declared as open if a class will derive from it.
open class Animal(private val name :String, private val livingArea: EnvironmentEnum)
{

    // A method has to declared open if it will be overriden by another class.
    open fun saySomething(){
        println("I cannot")
    }
    //Method for all subclasses.
    fun printAnimal(){
        println("I am $name living in ${livingArea.environmentName}")
    }
}