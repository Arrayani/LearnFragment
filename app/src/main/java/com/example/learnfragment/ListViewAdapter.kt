package com.example.learnfragment

//import example.abhiandroid.searchviewexample.AnimalNames.animalName

import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import java.util.*

class ListViewAdapter(// Declare Variables
    var mContext: FragmentActivity, animalNamesList: MutableList<AnimalNames>?
) : BaseAdapter() {
    var inflater: LayoutInflater
    private var animalNamesList: MutableList<AnimalNames>? = null
    private val arraylist: ArrayList<AnimalNames>

    inner class ViewHolder {
        var name: TextView? = null
    }

    override fun getCount(): Int {
        return animalNamesList!!.size
    }

    override fun getItem(position: Int): AnimalNames {
        return animalNamesList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.list_view_items, null)
            //view= LayoutInflater.from(mContext).inflate(R.layout.list_view_items,null)
            // Locate the TextViews in listview_item.xml
            holder.name = view.findViewById<View>(R.id.name) as TextView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.name!!.text = animalNamesList!![position].animalName
        return view
    }

    // Filter Class
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        animalNamesList!!.clear()
        if (charText.length == 0) {
            animalNamesList!!.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.animalName.toLowerCase(Locale.getDefault()).contains(charText)) {
                    animalNamesList!!.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

    init {
        this.animalNamesList = animalNamesList
        //inflater = LayoutInflater.from(mContext)
        inflater = LayoutInflater.from(mContext!!)
        arraylist = ArrayList()
        arraylist.addAll(animalNamesList!!)
    }
}