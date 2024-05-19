package com.alamin.firebaseauthenticationxm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alamin.firebaseauthenticationxm.databinding.ActivityHomeBinding
import com.alamin.firebaseauthenticationxm.viewmodel.AuthViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.logoutBtn.setOnClickListener {
            viewModel.signout()
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}