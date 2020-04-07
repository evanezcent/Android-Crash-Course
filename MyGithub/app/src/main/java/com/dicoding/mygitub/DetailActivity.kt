package com.dicoding.mygitub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val intent = Intent(this@DetailActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val USERNAME = "username"
        const val LINK = "link"
        const val DESCRIPTION = "description"
        const val STAR = "star"
        const val FORK = "fork"
        const val WATCH = "watch"
        const val BITMAP = "avatar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvUsername : TextView = findViewById(R.id.tv_username)
        val tvDesc : TextView = findViewById(R.id.tv_description)
        val tvLink : TextView = findViewById(R.id.tv_link_repo)
        val tvStar : TextView = findViewById(R.id.tv_star)
        val tvFork : TextView = findViewById(R.id.tv_fork)
        val tvWatch : TextView = findViewById(R.id.tv_watch)
        val imgAvatar : ImageView = findViewById(R.id.ci_avatar_2)

        val username = intent.getStringExtra(USERNAME)
        val link = intent.getStringExtra(LINK)
        val description = intent.getStringExtra(DESCRIPTION)
        val star = intent.getIntExtra(STAR, 0)
        val fork = intent.getIntExtra(FORK, 0)
        val watch = intent.getIntExtra(WATCH, 0)
        val avatar = intent.getStringExtra(BITMAP)

        tvUsername.text = username
        tvDesc.text = description
        tvLink.text = "https://www.github.com/evanezcent/${link}"
        tvStar.text = star.toString()
        tvFork.text = fork.toString()
        tvWatch.text = watch.toString()
        Picasso.get().load(avatar).into(imgAvatar)

        val btnMe : Button = findViewById(R.id.btn_me)
        btnMe.setOnClickListener(this)

    }
}
