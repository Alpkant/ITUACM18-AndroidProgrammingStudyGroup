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
import itu.ituacm.week4real.Note
import itu.ituacm.week4real.NoteAdapter
import itu.ituacm.week4real.R
import java.util.*

class MainFragment : Fragment(){
    companion object {
        fun newInstance(): MainFragment{
            return MainFragment()
        }
    }

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var editText:EditText
    lateinit var recyclerView: RecyclerView
    lateinit var button:Button
    lateinit var adapter: NoteAdapter
    var noteText:String = ""
    var notes : ArrayList<Note> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.main_fragment,container,false)
        val activity = activity
        button = view.findViewById(R.id.button)
        editText = view.findViewById(R.id.editText)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = NoteAdapter(notes,activity!!.applicationContext)
        recyclerView.adapter = adapter


        button.setOnClickListener {
            val noteText = editText.text.toString()
            editText.setText("")
            addNote(noteText)
        }
        return view
    }

    fun addNote( noteText:String){
        val currentPos = notes.size+1
        notes.add(Note("Title $currentPos",noteText,currentPos))
        adapter.notifyDataSetChanged()
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val resources = context!!.resources
    }
}