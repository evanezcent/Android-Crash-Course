package com.dicoding.picodiploma.dicoding_second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MovedActivityData : AppCompatActivity() {
    companion object{
        const val AGE = "UMUR"
        const val NAME = "NAMA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moved_data)

        val tvData : TextView = findViewById(R.id.tv_received_data)

        val name = intent.getStringExtra(NAME)
        val age = intent.getIntExtra(AGE,0)
        val text = "Nama : $name \n Umur : $age"
        tvData.text = text
    }
}
