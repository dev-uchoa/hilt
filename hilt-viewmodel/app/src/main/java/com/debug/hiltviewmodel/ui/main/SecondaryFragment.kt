package com.debug.hiltviewmodel.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.debug.hiltviewmodel.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondaryFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    companion object {
        fun newInstance() = SecondaryFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("Memory address", "$viewModel")
    }
}