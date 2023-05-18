package com.example.customlistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HairDesignAdapter : RecyclerView.Adapter<HairDesignAdapter.StudentViewHolder>(){

    private var stdList : ArrayList<HairDesignModel> = ArrayList()
    private var onClickItem: ((HairDesignModel) -> Unit)? = null
    private var onClickDeleteItem: ((HairDesignModel) -> Unit)? = null

    fun addItems(items:ArrayList<HairDesignModel>){
        this.stdList = items
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (HairDesignModel)-> Unit){
        this.onClickItem = callback
    }

    fun setOnClickDeleteItem(callback: (HairDesignModel)-> Unit){
        this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= StudentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_items_hdatc,parent,false)
    )

    override fun getItemCount(): Int {
        return stdList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val std = stdList[position]
        holder.bindView(std)
        holder.itemView.setOnClickListener{onClickItem?.invoke(std)}
        holder.btnDelete.setOnClickListener{onClickDeleteItem?.invoke(std)}
    }

    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        private var id = view.findViewById<TextView>(R.id.tvID)
        private var name = view.findViewById<TextView>(R.id.tvName)
        private var email = view.findViewById<TextView>(R.id.tvEmail)
        var btnDelete = view.findViewById<TextView>(R.id.btnDelete)

        fun bindView(std: HairDesignModel){
            id.text = std.id.toString()
            name.text = std.name.toString()
            email.text = std.email.toString()
        }
    }

}