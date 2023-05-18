package com.example.customlistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter : RecyclerView.Adapter<CartAdapter.StudentViewHolder>(){

    private var stdList : ArrayList<CartModel> = ArrayList()
    private var onClickItem: ((CartModel) -> Unit)? = null
    private var onClickDeleteItem: ((CartModel) -> Unit)? = null

    fun addItems(items:ArrayList<CartModel>){
        this.stdList = items
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (CartModel)-> Unit){
        this.onClickItem = callback
    }

    fun setOnClickDeleteItem(callback: (CartModel)-> Unit){
        this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= StudentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_items_std,parent,false)
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

        fun bindView(std: CartModel){
            id.text = std.id.toString()
            name.text = std.name.toString()
            email.text = std.email.toString()
        }
    }

}