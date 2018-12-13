package itu.ituacm.week4real.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import itu.ituacm.week4real.Note
import itu.ituacm.week4real.R

private const val ARG_PARAM1 = "param1"

class NoteFragment : Fragment() {
    private var param1: String? = null

    private var note: Note? = null

    private lateinit var noteTitle: TextView
    private lateinit var noteData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        noteTitle = view.findViewById(R.id.note_fragment_title)
        noteData  = view.findViewById(R.id.note_fragment_data)
        noteTitle.text = note?.noteTitle
        noteData.text = note?.noteData
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, noteToOpen: Note) =
            NoteFragment().apply {
                note = noteToOpen
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
