package com.example.fragments_kotlin_task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments_kotlin_task2.fragment.FirstFragment
import com.example.fragments_kotlin_task2.fragment.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.FirstListener,
    SecondFragment.SecondListener {
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    override fun onFirstSend(user: User) {
        secondFragment.updateSecondText(user)
    }

    override fun onSecondSend(user: User) {
        firstFragment.updateFirstText(user)
    }

    private fun initViews() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameFirst, firstFragment)
            .replace(R.id.frameSecond, secondFragment)
            .commit()
    }
}