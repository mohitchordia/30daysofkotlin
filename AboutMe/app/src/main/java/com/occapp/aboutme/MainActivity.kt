package com.occapp.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{ updateNickname(it) }
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val done = findViewById<Button>(R.id.done_button)
        view.visibility = View.GONE
        done.visibility = View.VISIBLE
        editText.visibility = View.VISIBLE
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nntextView = findViewById<TextView>(R.id.nickname_text)
        nntextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nntextView.visibility = View.VISIBLE
    }
}
