package com.example.form

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.time.Month
import java.time.Year
import java.util.Calendar
import android.app.AlertDialog
import android.content.DialogInterface

class MainActivity : AppCompatActivity() {
    private lateinit var editTextDate: EditText
    private lateinit var calendar: Calendar
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextID = findViewById<EditText>(R.id.editTextID)
        val editTextPWD = findViewById<EditText>(R.id.editTextPWD)
        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radBtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Male)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox_Car)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox_Bicycle)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox_Motorcycle)
        val applyDate = findViewById<EditText>(R.id.editTextDate)
        var gender:String = ""
        editTextDate = findViewById(R.id.editTextDate)
        editTextDate.isFocusable = false // 避免直接點擊彈出軟鍵盤

        val btn_send = findViewById<Button>(R.id.btn_send)


        radGrp_Gender.setOnCheckedChangeListener { _, checkeId ->
            gender = radGrp_Gender.findViewById<RadioButton>(checkeId).text.toString()
        }

        btn_send.setOnClickListener {
            var msg = ""
            if(checkBox1.isChecked()){
                msg = msg + checkBox1.getText().toString()
            }
            if(checkBox2.isChecked()){
                msg = msg + "、" + checkBox2.getText().toString()
            }
            if(checkBox3.isChecked()){
                msg = msg + "、" + checkBox3.getText().toString()
            }
            val name = editTextName.text.toString()
            val ID = editTextID.text.toString()
            val PWD = editTextPWD.text.toString()
            val birthday = editTextDate.text.toString()

            showDialog(ID, PWD, name, birthday, gender, msg)
        }

        applyDate.setOnClickListener{
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, {_, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    applyDate.setText(format)
                }
            }, year, month, day).show()
        }
    }
    private fun setDateFormat(year: Int, month: Int, day: Int):String{
        return "$year-${month + 1}-$day"
    }

    private  fun showDialog(ID: String, PWD: String, name: String, birthday: String, gender: String, msg: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("表單內容")
        val message = "ID: $ID\nPWD: ${hidePassword(PWD)}\nName: $name\nBirthday: $birthday\nGender: $gender\nVehicle: $msg"
        builder.setMessage(message)
        builder.setPositiveButton("確定"){dialog, which ->
            dialog.dismiss()// 關閉對話框
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun hidePassword(PWD: String): String{
        if(PWD.length <= 2) return PWD
        val firstTwoChars = PWD.substring(0,2)
        val lastChar = PWD.substring(PWD.length - 2)
        val hiddenPart = "*".repeat(PWD.length - 4)
        return "$firstTwoChars$hiddenPart$lastChar"
    }
}