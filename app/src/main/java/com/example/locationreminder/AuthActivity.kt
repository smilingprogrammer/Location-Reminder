package com.example.locationreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.locationreminder.databinding.ActivityAuthBinding
import com.firebase.ui.auth.AuthUI

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private val viewModel by viewModels<AuthViewModel>()

    companion object {
        const val TAG = "AuthActivity"
        const val SIGN_IN_RESULT_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.authenticateButton.setOnClickListener { launchSignInUIFlow() }

        viewModel.authenticationState.observe(this){
            when (it) {
                AuthViewModel.AuthenticationState.AUTHENTICATED -> switchActivities()
                else -> Log.e(TAG, "Authentication $it")
            }
        }
    }

    private fun launchSignInUIFlow() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                providers
            ).build(), SIGN_IN_RESULT_CODE
        )
    }

    private fun switchActivities() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}