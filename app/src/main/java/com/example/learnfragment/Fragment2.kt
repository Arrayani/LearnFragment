package com.example.learnfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learnfragment.databinding.Fragment2Binding

/**

 * Author: Roni Reynal Fitri  on $ {DATE} $ {HOUR}: $ {MINUTE}

 * Email: biruprinting@gmail.com

 */
class Fragment2:Fragment(R.layout.fragment2) {
    private var _binding: Fragment2Binding? =null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2Binding.inflate(inflater,container,false)
        //return super.onCreateView(inflater, container, savedInstanceState)


        binding.text2Tv.text="Programaticcaly Edited"
// return taronya di bawah, kalo di atas coding yang sebelumnya tidak tereksekusi
        return binding.root

        binding.text2Tv.text="after return" // ini ga bakal di eksekusi
    }

    override fun onDestroy() {
        _binding = null // agar tidak terjadi memory leak
        super.onDestroy()
    }
}