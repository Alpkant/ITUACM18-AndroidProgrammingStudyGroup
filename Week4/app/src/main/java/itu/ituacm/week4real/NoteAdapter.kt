package itu.ituacm.week4real

import android.content.Context
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.*

class NoteAdapter(val notes: ArrayList<Note>, val context: Context, val clickInterface: clickInterface) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteText.text = notes[position].noteData
        holder.noteTitle.text = notes[position].noteTitle
        val rnd = Random()
        holder.background.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)))
        holder.background.setOnClickListener { clickInterface.onItemClick(position) }
        holder.deleteButton.setOnClickListener { clickInterface.onItemDelete(position) }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteText: TextView = view.findViewById<TextView>(R.id.note_text)
        val noteTitle: TextView = view.findViewById(R.id.note_title)
        val background : ConstraintLayout = view.findViewById(R.id.list_item_constraint)
        val deleteButton: Button = view.findViewById<Button>(R.id.delete_note_button)
    }

}