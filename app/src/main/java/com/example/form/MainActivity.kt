package com.example.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radBtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Male)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox_Car)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox_Bicycle)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox_Motorcycle)

        val btn_send = findViewById<Button>(R.id.btn_send)


        radGrp_Gender.setOnCheckedChangeListener { _, checkeId ->
            val gender = radGrp_Gender.findViewById<RadioButton>(checkeId).text.toString()
            Toast.makeText(this, gender, Toast.LENGTH_SHORT).show()
        }

        btn_send.setOnClickListener {
            var msg = ""
            if(checkBox1.isChecked()){
                msg = msg + checkBox1.getText().toString()
            }
            if(checkBox2.isChecked()){
                msg = msg + checkBox2.getText().toString()
            }
            if(checkBox3.isChecked()){
                msg = msg + checkBox3.getText().toString()
            }
        }
    }
}