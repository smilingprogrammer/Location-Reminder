package com.example.locationreminder

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.locationreminder.databinding.ReminderFragmentBinding
import com.firebase.ui.auth.AuthUI

class ReminderFragment : Fragment() {

    private var _binding: ReminderFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ReminderViewModel>()
//    private val viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(
//    Application()
//    )).get(ReminderViewModel::class.java)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = ReminderFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        binding.refreshLayout.setOnRefreshListener { viewModel.loadReminders() }
        binding.addReminder.setOnClickListener {
            findNavController().navigate(
                ReminderFragmentDirections.actionReminderFragmentToSaveFragment()
            )
        }
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.loadReminders()
//    }

    private fun setUpRecyclerView() {
        val adapter = ReminderAdapter()
        binding.reminderRecyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                AuthUI.getInstance().signOut(requireContext())
                    .addOnCompleteListener {
                    val intent = Intent(activity, AuthActivity::class.java)
                        startActivity(intent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.main_menu, menu)
    }

}