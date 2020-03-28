package id.kotlin.sa_first

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        val toastt = findViewById<Button>(R.id.btnClick1)
        toastt.setOnClickListener { Toast.makeText(this,"INI TOAST", Toast.LENGTH_SHORT).show() }

        val rootLayout = findViewById<LinearLayout>(R.id.mainLayout)
        val snackk = findViewById<Button>(R.id.btnClick2)
        snackk.setOnClickListener { Snackbar.make(rootLayout, "INI SNACKBAR", Snackbar.LENGTH_SHORT).show() }

        supportFragmentManager.beginTransaction().replace(R.id.fl_Main, MainFragment()).commit()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}