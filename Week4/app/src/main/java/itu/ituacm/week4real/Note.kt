package itu.ituacm.week4real

class Note(var id: Int ,var noteTitle:String,var noteData:String,val type:Int) {
    constructor():this(-1,"","",-1)
}