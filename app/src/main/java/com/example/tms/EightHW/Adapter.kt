package com.example.tms.EightHW


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.EightHW.Database.entity.Phone
import kotlinx.android.synthetic.main.item_phone.view.*

class Adapter(private val phones:List<Phone>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_phone, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.apply {
            textView_phone_model.text=phones[position].model
            textView_phone_os.text= phones[position].os
            textView_phone_price.text= phones[position].price.toString()
        }
    }

    override fun getItemCount(): Int {
        return phones.size
    }
}