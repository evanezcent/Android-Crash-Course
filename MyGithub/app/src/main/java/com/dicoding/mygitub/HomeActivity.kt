package com.dicoding.mygitub

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mygitub.Api.ApiProvider
import com.dicoding.mygitub.Model.Datasource
import com.dicoding.mygitub.Model.Response
import retrofit2.Call
import retrofit2.Callback

class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view)

        val data = ApiProvider.provideHttpAdapter().create(Datasource::class.java)
        data.getRepo().enqueue(object : Callback<Response>{
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val res : ArrayList<Response> = response.body().re
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_repo)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = CardAdapter(res)
            }
        })
    }
}