package com.yeonkims.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.yeonkims.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // This binding object is like a layer of glue between layout, its views and data.
    private lateinit var binding: ActivityMainBinding

    private val myNameData: MyName = MyName("Kim Jiyeon")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        binding.myNameLayout = myNameData

        // We can now access the doneButton through to binding object.
        binding.doneButton.setOnClickListener {
            addNickname((it))
        }
    }

    // View is for view on which the function was called, so that's our Done button.
    private fun addNickname(view: View) {

        binding.apply {
            myNameData?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}