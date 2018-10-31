//Our Mother class implements the interface methods.
class Mother(private val child:Child) : ChildMotherInterface {

    //-----------Interface methods-------------
    /*
       Events occurred in the Main.kt but their implementations are done here.
     */
    override fun onPlaneTakeOff() {
        println("Mom: Have a nice flight my child ${child.name}!\n")
    }

    override fun onPlaneLand(cityName:String) {
        println("Mom: Oh! Thanks God!\nMy child is now in $cityName\n")
    }

    //-----------------------------------

    // This is necessary to invoke the above methods.
    fun setInterface(){
        child.setInterface(this)
        // This represents class here.
        // Saying that class will implement these functions.
    }
}