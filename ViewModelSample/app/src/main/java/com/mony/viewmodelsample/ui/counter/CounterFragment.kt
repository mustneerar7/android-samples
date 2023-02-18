package com.mony.viewmodelsample.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mony.viewmodelsample.R
import com.mony.viewmodelsample.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    // Accessing viewModel via delegate
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflating a layout with view binding enabled
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_counter, container, false)

        // Linking viewModel directly to layout
        binding.counterViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        USE THIS MODULE TO UPDATE LIVE DATA WHEN VIEW BINDING IS NOT BEING USED

        viewModel.currentCount.observe(viewLifecycleOwner, {
            nextCount -> binding.countTextView.text = nextCount.toString()
        })
         */
    }
}