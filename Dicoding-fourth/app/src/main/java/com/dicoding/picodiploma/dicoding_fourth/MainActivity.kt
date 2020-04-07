package com.dicoding.picodiploma.dicoding_fourth

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvPahlawan: RecyclerView
    private var list: ArrayList<Pahlawan> = arrayListOf()

    private var title: String = "List Mode"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvPahlawan = findViewById(R.id.rv_heroes)
        rvPahlawan.setHasFixedSize(true)

        list.addAll(DataPahlawan.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val listAdapterPahlawan = ListAdapterPahlawan(list)
        rvPahlawan.adapter = listAdapterPahlawan

        listAdapterPahlawan.setOnItemClickCallback(object : ListAdapterPahlawan.OnItemClickCallback{
            override fun onItemClicked(data: Pahlawan) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid(){
        rvPahlawan.layoutManager = GridLayoutManager(this,2)
        val gridAdapterPahlawan = GridAdapterPahlawan(list)
        rvPahlawan.adapter = gridAdapterPahlawan

        gridAdapterPahlawan.setOnItemClickCallback(object: ListAdapterPahlawan.OnItemClickCallback{
            override fun onItemClicked(data: Pahlawan) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCard(){
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val cardAdapterPahlawan = CardAdapterPahlawan(list)
        rvPahlawan.adapter = cardAdapterPahlawan
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectMode: Int){
        when(selectMode){
            R.id.action_list -> {
                title = "List Mode"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Grid Mode"
                showRecyclerGrid()
            }
            R.id.action_card -> {
                title = "Card Mode"
                showRecyclerCard()
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as androidx.appcompat.app.ActionBar).title = title
        }
    }
    private fun showSelectedHero(hero: Pahlawan) {
        Toast.makeText(this, "Kamu memilih " + hero.nama, Toast.LENGTH_SHORT).show()
    }
}
