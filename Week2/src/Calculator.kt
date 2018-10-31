class Calculator(private val a:Int,private val b:Int,private val operation:Int) {


    init {
        // When an object is created call one of these functions.
        val res =
        when(operation){
            0 -> calculate {sum()}
            1 -> calculate {diff()}
            2 -> calculate {multiply()}
            3 -> calculate {divide()}
            else -> 0
        }
        println("Result of the operation is $res")
    }

    // Below functions operate on attributes a and b.
    // Func is a function which is passed to another function.
    // Func takes no argument and returns Int.
    private fun calculate(func: () ->  Int ):Int{
        return func()
        // Calls the function which is passed to calculate function.
    }

    private fun sum():Int{
        return a+b
    }
    private fun diff():Int{
        return a-b
    }
    private fun multiply():Int{
        return a*b
    }
    private fun divide():Int{
        return a/b
    }
}