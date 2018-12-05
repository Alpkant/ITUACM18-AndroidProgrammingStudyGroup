package com.itu.dailyfilm.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itu.dailyfilm.Models.ChatItem
import com.itu.dailyfilm.R

class ChatAdapter(private val messagesList:List<ChatItem>) :
        RecyclerView.Adapter<ChatAdapter.ViewHolder>(){

    private val USER_TYPE = 0
    private val NOT_USER_TYPE = 1

    // Open different layouts for different message types.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder{
        val itemView =  if (viewType == USER_TYPE)
            LayoutInflater.from(parent.context).inflate(R.layout.chat_item_send, parent, false)
        else
            LayoutInflater.from(parent.context).inflate(R.layout.chat_item_received, parent, false)

        return ChatAdapter.ViewHolder(itemView)
    }

    // Function to return the type of the chat item to onCreateViewHolder.
    // Separate send and received messages here.
    override fun getItemViewType(position: Int): Int {
        val item = messagesList[position]
        return if(item.isUser)
            USER_TYPE
        else NOT_USER_TYPE
    }

    override fun getItemCount() = messagesList.size

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        val chatItem = messagesList[position]
        // Fill the info to the views
        holder.date.text = chatItem.sendDate.toString()
        holder.userName.text = chatItem.senderName
        holder.message.text = chatItem.message

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        val userName = view.findViewById<TextView>(R.id.chat_item_user)
        val date = view.findViewById<TextView>(R.id.chat_item_date)
        val message = view.findViewById<TextView>(R.id.chat_item_message)
    }

}