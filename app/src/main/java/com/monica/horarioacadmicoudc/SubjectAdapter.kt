package com.monica.horarioacadmicoudc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectAdapter(private val data: ArrayList<SubjectItem>) :
    RecyclerView.Adapter<SubjectAdapter.ViewHolder?>() {
    private var parentRecycler: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        parentRecycler = recyclerView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.item_subject_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val content = data[position]
        holder.nameTextView.text = content.name
        holder.weeklyHourTextView.text = "${content.weeklyHours}"
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val nameTextView: TextView = itemView.findViewById(R.id.txt_name)
        val weeklyHourTextView: TextView = itemView.findViewById(R.id.txt_weekly_hour)
    }
}