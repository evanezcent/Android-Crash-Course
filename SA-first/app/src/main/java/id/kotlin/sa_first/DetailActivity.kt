package id.kotlin.sa_first

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val itemAdapter = findViewById<RecyclerView>(R.id.rv_detail)
        itemAdapter.adapter = DetailAdapter()
    }
}