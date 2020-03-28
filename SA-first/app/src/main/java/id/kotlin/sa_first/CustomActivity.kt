package id.kotlin.sa_first

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class CustomActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        val viewGroup = findViewById<FrameLayout>(R.id.fl_custom)
        viewGroup.removeAllViews()
        viewGroup.addView(CustomController(this))
    }
}