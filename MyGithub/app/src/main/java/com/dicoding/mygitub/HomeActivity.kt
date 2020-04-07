package com.dicoding.mygitub

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mygitub.Api.ApiProvider
import com.dicoding.mygitub.Model.Datasource
import com.dicoding.mygitub.Model.Repo
import kotlinx.android.synthetic.main.main_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_view)

        val repo = ApiProvider.provideHttpAdapter().create(Datasource::class.java)
        repo.getRepo().enqueue(object : Callback<ArrayList<Repo>>{
            override fun onFailure(call: Call<ArrayList<Repo>>, t: Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<ArrayList<Repo>>, response: Response<ArrayList<Repo>>) {
                val repositories = response.body()!!
                rv_repo.apply {
                    layoutManager = LinearLayoutManager(this@HomeActivity)
                    adapter = CardAdapter(repositories ?: emptyList<Repo>())
                }
            }
        })
    }
}