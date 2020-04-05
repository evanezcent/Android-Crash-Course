package com.dicoding.picodiploma.dicoding_second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveData : Button = findViewById(R.id.btn_move_data)
        btnMoveData.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity ->{
                val movedIntent = Intent(this@MainActivity, MovedActivity::class.java)
                startActivity(movedIntent)
            }

            R.id.btn_move_data ->{
                val movedDataIntent = Intent(this@MainActivity, MovedActivityData::class.java)
                movedDataIntent.putExtra(MovedActivityData.NAME, "Tama")
                movedDataIntent.putExtra(MovedActivityData.AGE, 20)
                startActivity(movedDataIntent)
            }
        }
    }

}
