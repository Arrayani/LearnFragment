package com.example.learnfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnfragment.databinding.ListViewItemsBinding

class RecViewAdapter(fragment1: Fragment1, arraylist: ArrayList<AnimalNames>):
RecyclerView.Adapter<RecViewAdapter.MyViewHolder>(){
   var arraylist = ArrayList<AnimalNames>()
    class MyViewHolder(val binding:ListViewItemsBinding):RecyclerView.ViewHolder(binding.root) {

    }

        fun setData(newBarangList: ArrayList<AnimalNames>){
        this.arraylist = newBarangList
        notifyItemChanged(arraylist.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListViewItemsBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = arraylist[position]
        holder.binding.name.text = currentItem.animalName
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

}
