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

class FirstFragment : Fragment() {
    private var listener: FirstListener? = null
    private var textData: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        initViews(view)
        return view
    }

    fun initViews(view: View) {
        textData = view.findViewById(R.id.first_text_data)
        val bFirst = view.findViewById<Button>(R.id.b_first)
        bFirst.setOnClickListener {
            listener!!.onFirstSend(User("PDP","22"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener) {
            context
        }else {
            throw RuntimeException("$context must implements FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateFirstText(user: User) {
        textData!!.text = user.toString()
    }

    interface FirstListener {
        fun onFirstSend(user: User)
    }
}