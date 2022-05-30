package com.example.locationreminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.locationreminder.databinding.SaveFragmentBinding

class SaveFragment : Fragment() {
//
//    companion object {
//        fun newInstance() = SaveFragment()
//    }

    private var _binding: SaveFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SaveViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SaveFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}