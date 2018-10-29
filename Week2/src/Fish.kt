class Fish(name : String): Animal(name,EnvironmentEnum.SEA) {

    override fun saySomething() {
        // Super keyword represents parent class
        super.saySomething()
        // This function will do same thing as parent to
        // Thus, there is no need to overrride.
    }
}