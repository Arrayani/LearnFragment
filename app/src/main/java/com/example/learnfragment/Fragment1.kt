package com.example.learnfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.learnfragment.databinding.Fragment1Binding
import java.util.ArrayList

/**

 * Author: Roni Reynal Fitri  on $ {DATE} $ {HOUR}: $ {MINUTE}

 * Email: biruprinting@gmail.com

 */



class Fragment1: Fragment(R.layout.fragment1), SearchView.OnQueryTextListener {

    var list: ListView? = null
    var adapter: ListViewAdapter? = null
    var editsearch: SearchView? = null
    lateinit var animalNameList: Array<String>
    var arraylist = ArrayList<AnimalNames>()

    private var _binding: Fragment1Binding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Fragment1Binding.inflate(inflater,container,false)


        // Generate sample data
        animalNameList = arrayOf(
            "Lion", "Tiger", "Dog",
            "Cat", "Tortoise", "Rat", "Elephant", "Fox",
            "Cow", "Donkey", "Monkey"
        )

        val list = binding.listview
        for (i in animalNameList.indices) {
            val animalNames = AnimalNames(animalNameList[i])
            // Binds all strings into an array
            arraylist.add(animalNames)
        }

        // Pass results to ListViewAdapter Class
        //adapter = ListViewAdapter(this, arraylist)
        adapter = ListViewAdapter(requireActivity(), arraylist)

        // Binds the Adapter to the ListView
        list.adapter = adapter

        val editsearch = binding.search
        editsearch.setOnQueryTextListener(this@Fragment1)

        return binding.root

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapter!!.filter(newText.toString())
        return false
    }


}