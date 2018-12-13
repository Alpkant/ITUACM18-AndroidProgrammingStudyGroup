package itu.ituacm.week4real.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import itu.ituacm.week4real.*
import org.w3c.dom.Node
import java.util.*

class MainFragment : Fragment(), clickInterface{

    override fun onItemDelete(pos: Int) {
        var toDelete = pos
        if (pos >= notes.size)
            toDelete = pos % notes.size
        // Remove from database
        dbHelper?.deleteNode(notes[toDelete].id)
        // Remove from list
        notes.removeAt(toDelete)

        adapter.notifyItemRemoved(toDelete)
        adapter.notifyItemRangeChanged(toDelete,toDelete + 1 )
    }

    companion object {
        fun newInstance(): MainFragment{
            return MainFragment()
        }
    }

    lateinit var editText:EditText
    lateinit var recyclerView: RecyclerView
    lateinit var button:Button
    lateinit var adapter: NoteAdapter

    var noteText:String = ""
    var notes : ArrayList<Note> = ArrayList()
    var dbHelper:DatabaseHelper? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.main_fragment,container,false)
        val activity = activity
        button = view.findViewById(R.id.button)
        editText = view.findViewById(R.id.editText)
        recyclerView = view.findViewById(R.id.recyler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = NoteAdapter(notes,activity!!.applicationContext, this)
        recyclerView.adapter = adapter


        button.setOnClickListener {
            val noteText = editText.text.toString()
            editText.setText("")
            addNote(noteText)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        context?.let {
            dbHelper = DatabaseHelper(context!!)
            readAllNotes()
        }
    }

    fun addNote(noteText:String){
        val currentPos = notes.size+1
        val noteToAdd = Note(-1,"Title $currentPos",noteText,currentPos)
        notes.add(noteToAdd)
        adapter.notifyItemInserted(currentPos)
        writeNoteToDataBase(noteToAdd)
    }

    private fun writeNoteToDataBase(note: Note){
        dbHelper?.addNote(note)
    }

    private fun readAllNotes(){
        dbHelper?.let {
            val notesList = dbHelper!!.getAllNotes()
            notes = notesList as ArrayList<Note>
            adapter = NoteAdapter(notes, context!!, this)
            recyclerView.adapter = adapter
        }
    }

    override fun onItemClick(pos: Int) {
        (activity as MainActivity).openFragment(NoteFragment.newInstance("",notes[pos]), "Notes")
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val resources = context!!.resources
    }
}