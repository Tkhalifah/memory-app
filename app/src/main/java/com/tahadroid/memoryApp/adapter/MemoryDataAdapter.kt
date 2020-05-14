package com.tahadroid.memoryApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahadroid.memoryApp.R
import com.tahadroid.memoryApp.repository.local.Memory
import kotlinx.android.synthetic.main.layout_memory_data_item.view.*

//private const val VIEW_TYPE_ONE = 0;
//private const val VIEW_TYPE_TWO = 2;

class MemoryDataAdapter(var list: MutableList<Memory>, val clickListener:(Memory)->Unit) ://1
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//if(viewType== VIEW_TYPE_ONE)// and so on
        return MemoryDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_memory_data_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (getItemViewType(position) == VIEW_TYPE_TWO) //and so on

        (holder as MemoryDataViewHolder).bind(list[position],clickListener) // 4
    }
fun removeAt(){
    notifyDataSetChanged()
}
    // if i need multible view type
//    override fun getItemViewType(position: Int): Int {
//        return if (list[position].view_type == 0L){
//            VIEW_TYPE_ONE
//        }else{
//            VIEW_TYPE_TWO
//        }
//    }
    class MemoryDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            memory: Memory,
            clickListener: (Memory) -> Unit) { //2
            itemView.title_tv.text = memory.mTitle
            itemView.description_tv.text = memory.mDescription
            //listener  --> 3
            itemView.setOnClickListener {
               clickListener(memory)
            }
        }
    }
}