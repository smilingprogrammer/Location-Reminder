package com.example.locationreminder

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.locationreminder.databinding.ReminderFragmentBinding

class ReminderFragment : Fragment() {

    private var _binding: ReminderFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = ReminderFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}