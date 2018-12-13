package itu.ituacm.week4real

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.security.AccessControlContext

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,DATABASE_VERSION){
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME  = "notes.db"
        const val TABLE_NAME = "NOTE"
        const val col_title = "title"
        const val col_data = "data"
        const val col_id = "id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create the table for a first time.
        val sql = "CREATE TABLE $TABLE_NAME ($col_id INTEGER PRIMARY KEY,$col_title TEXT,$col_data TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // If table updated, delete it and start new table
        val sql = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(sql)
        onCreate(db)
    }

    fun deleteNode(id: Int){
        val db = this.writableDatabase
        val selection = "$col_id = ?"
        val selectionArgs = arrayOf("$id")
        val deletedRows = db.delete(TABLE_NAME, selection, selectionArgs)
        Log.e("Database", "$deletedRows number of rows are deleted")
    }

    fun addNote(note :Note){
        val db = this.writableDatabase
        Log.e("Database", "Addnote")
        val values = ContentValues()

        values.put(col_title, note.noteTitle)
        values.put(col_data, note.noteData)

        db.insert(TABLE_NAME, null , values)
        db.close()
    }


    fun getAllNotes() : MutableList<Note>{
        val noteList = mutableListOf<Note>()
        Log.e("Database", "GetNotes")
        val db = this.readableDatabase
        // Which column names will be queried
        val colNames = arrayOf(col_id, col_title, col_data)

        val cursor = db.query(TABLE_NAME, colNames, null, null, null, null, null)

        // Iterate on queried data
        while(cursor.moveToNext()){
            val newNote = Note()
            newNote.id = cursor.getString(0).toInt()
            newNote.noteTitle = cursor.getString(1)
            newNote.noteData = cursor.getString(2)

            noteList.add(newNote)
        }

        cursor.close()
        db.close()
        return noteList
    }





}