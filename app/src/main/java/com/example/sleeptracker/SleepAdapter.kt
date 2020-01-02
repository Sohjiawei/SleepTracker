package com.example.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepAdapter internal constructor(context: Context):RecyclerView.Adapter<SleepAdapter.SleepViewHolder>(){
    private val inflater:LayoutInflater = LayoutInflater.from(context)
    private val sleeps = emptyList<Sleep>()//cached copy of words

    inner class SleepViewHolder(itemView: RecyclerView.ViewHolder(itemView)){
        val textViewQualityValue: TextView = itemView.findViewById(R.id.textViewQualityValue)
        val textViewStart : TextView = itemView.findViewById(R.id.textViewStart)
        val textViewModel : TextView = itemView.findViewById(R.id.textViewEnd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val itemView = inflater.inflate(R.Layout.recycleview_item,parent,false)
        return SleepViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return sleeps.size
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val sleepRec: Sleep = sleeps.get(position)
        holder.textViewQualityValue.text = sleepRec.quality.toString()

        holder.textViewStart.text = SimpleDataformat("yy/mm/dd,HH:MM").format(sleepRec.startDate)
        holder.textViewEnd.text= SimpleDataformat("yy/mm/dd,HH:MM").format(sleepRec.endDate)
    }

    override fun getItemCount():Int{
        return sleep.size
    }
}