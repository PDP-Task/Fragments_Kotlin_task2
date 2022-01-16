package com.example.fragments_kotlin_task2.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.fragments_kotlin_task2.R
import com.example.fragments_kotlin_task2.User
import java.lang.RuntimeException

class SecondFragment : Fragment() {

    private var listener: SecondListener? = null
    private var textData: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_second, container, false)
        initViews(view)
        return view
    }

    fun initViews(view: View) {
        textData = view.findViewById(R.id.second_text_data)
        val btn = view.findViewById<Button>(R.id.b_second)
        btn.setOnClickListener {
            listener!!.onSecondSend(User("Academy","23"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        }else {
            throw RuntimeException("$context must implements SecondListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateSecondText(user: User) {
        textData!!.text = user.toString()
    }

    interface SecondListener {
        fun onSecondSend(user: User)
    }
}