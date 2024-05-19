package com.alamin.firebaseauthenticationxm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.alamin.firebaseauthenticationxm.databinding.ActivityLogInBinding
import com.alamin.firebaseauthenticationxm.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLogInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please fill up all the fields!!!", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.signIn(email,password).observe(this, {
                    Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
                    if(it.equals("Sign in successful")){
                        startActivity(Intent(this, HomeActivity::class.java))
                    }
                })


            }
        }
        binding.registerTxt.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        if(FirebaseAuth.getInstance().currentUser?.uid!=null){
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}