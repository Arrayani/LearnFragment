package com.example.learnfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnfragment.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(homeFragment: HomeFragment) {
    val fragmentManager  = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,homeFragment)
        fragmentTransaction.commit()
    }
}