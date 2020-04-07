package com.dicoding.mygitub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mygitub.Api.ApiProvider
import com.dicoding.mygitub.Model.Datasource
import com.dicoding.mygitub.Model.Repo
import kotlinx.android.synthetic.main.main_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(p0: View?) {
        val intent = Intent(this@HomeActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_view)

        val me : ImageView = findViewById(R.id.ci_profil)
        me.setOnClickListener(this)

        val repo = ApiProvider.provideHttpAdapter().create(Datasource::class.java)
        repo.getRepo().enqueue(object : Callback<ArrayList<Repo>>{
            override fun onFailure(call: Call<ArrayList<Repo>>, t: Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<ArrayList<Repo>>, response: Response<ArrayList<Repo>>) {
                val repositories = response.body()!!
                rv_repo.apply {
                    layoutManager = LinearLayoutManager(this@HomeActivity)
                    adapter = CardAdapter(repositories)
                }

            }
        })

    }
}