package com.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.aboutme.databinding.ActivityMainBinding
import com.aboutme.dataclass.MyName

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Awais Mansha","Owys")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        binding.button.setOnClickListener {
            addNickName(it)
        }
//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }
    }

    private fun addNickName(view: View){

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
           // nicknameText.text = nicknameEdit.text
            invalidateAll()
        }
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicNameTextView:TextView = findViewById(R.id.nickname_text)
//
//        view.visibility = View.GONE
//        editText.visibility = View.GONE
//        nicNameTextView.visibility = View.VISIBLE
//        nicNameTextView.text = editText.text

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}