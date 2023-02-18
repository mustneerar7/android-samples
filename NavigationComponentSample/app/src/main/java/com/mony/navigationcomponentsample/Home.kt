package com.mony.navigationcomponentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.mony.navigationcomponentsample.databinding.FragmentHomeBinding

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1 = view.findViewById<Button>(R.id.goToChatsButton)
        button1.setOnClickListener {

            // Navigating using save args method
            val action = HomeDirections.actionHome2ToChats()
            view.findNavController().navigate(action)
        }

        val button2 = view.findViewById<Button>(R.id.goToGalleryButton)
        button2.setOnClickListener {

            // Navigating using save args method
            val action = HomeDirections.actionHome2ToGallery()
            view.findNavController().navigate(action)
        }
    }
}