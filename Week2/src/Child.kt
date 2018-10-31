class Child(val name:String) {

    private var momInterface: ChildMotherInterface? = null

    //Assigning interface variable.
    fun setInterface(interfaceObj: ChildMotherInterface){
        momInterface = interfaceObj
    }

    fun getOnPlane(){
        //Invoke the interface method
        momInterface?.onPlaneTakeOff()
    }
    fun getOffFromPlane(city:String){
        //Invoke the interface method
        momInterface?.onPlaneLand(city)
    }
}