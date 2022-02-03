package com.example.androidpractise

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.androidpractise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Nisarg Mahyavanshi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.myName = this.myName;

        binding.doneButton.setOnClickListener{
            addNickName();
        }
    }

    private fun addNickName(){

        binding.nicknameText.setOnClickListener{
            updateNickName();
        }

//        binding.nicknameText.text = binding.nicknameEdit.text.toString();
        binding.apply {
            myName.nickname = binding.nicknameEdit.text.toString();
            binding.invalidateAll();
            binding.nicknameEdit.visibility = View.GONE;
            binding.nicknameText.visibility = View.VISIBLE;
        }
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0);
    }

    private fun updateNickName(){
        binding.nicknameText.visibility = View.GONE;
        binding.doneButton.visibility = View.VISIBLE;
        binding.nicknameEdit.visibility = View.VISIBLE;
        binding.nicknameEdit.requestFocus();
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        inputMethodManager.showSoftInput(binding.nicknameEdit, 0);
    }
}