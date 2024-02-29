package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.result_textView)
        val result_button = findViewById<Button>(R.id.result_button)
        val editText = findViewById<TextView>(R.id.editText)
        val guess_button = findViewById<Button>(R.id.guess_button)
        var validate_num:Int
        var start:Int = 1
        var end:Int = 100

        var secret : Int = Random().nextInt(100)+1

        guess_button.setOnClickListener {
            Toast.makeText(this, editText.text, Toast.LENGTH_LONG)
            textView.text=editText.text
            validate_num=editText.text.toString().toInt()-secret
            var ans_str:String="你猜對了喔"

            if(validate_num>0){
                end=editText.text.toString().toInt()
                var strend=end.toInt().toString()
                var strstart=start.toInt().toString()
                ans_str = strstart+" ~ "+strend
            }else if(validate_num<0){
                start=editText.text.toString().toInt()
                var strend=end.toInt().toString()
                var strstart=start.toInt().toString()
                ans_str = strstart+" ~ "+strend
            }
            textView.text=ans_str

        }

        result_button.setOnClickListener {
            secret=Random().nextInt(10)+1
            textView.text="我們再猜一次"
        }
    }
}