// Object classes are used to create static Classes.
// Everything in that class will be a static.
// This classes are useful when creating singleton objects.
object StringUtil {

    fun replaceName(sentence: String, toChange: String, replaceStr: String):String{
        return sentence.replace(toChange,replaceStr)
    }

}