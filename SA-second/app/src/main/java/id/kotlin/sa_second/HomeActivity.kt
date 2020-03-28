package id.kotlin.sa_second

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback

class HomeActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val progressBar = findViewById<ProgressBar>(R.id.pb_home)

        val data = ApiProvider.provideHttpAdapter().create(DataSource::class.java)
        data.getMovie().enqueue(object : Callback<Response>{

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                progressBar.visibility = View.GONE

                val res = response.body()?.res
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = HomeAdapter(res ?: emptyList())
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
            }
        })
    }
}