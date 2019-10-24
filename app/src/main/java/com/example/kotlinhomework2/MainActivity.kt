package com.example.kotlinhomework2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_choice.setOnClickListener{
            startActivityForResult(Intent(this,Main2Activity::class.java),1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if(requestCode==1 && resultCode== Activity.RESULT_OK){
                tv_meal.text="饮料：${it.getString("drink")}\n\n" +
                        "甜度：${it.getString("sugar")}\n\n"+
                        "冰块:${it.getString("ice")}"
            }
        }
    }
}
