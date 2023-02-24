package com.example.uklproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl.DataSepatu

class HomeActivity : AppCompatActivity() {

    private lateinit var rvSepatu: RecyclerView
    private var list : ArrayList<Sepatu> = arrayListOf()
    private var title: String = "RecyclerView"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setActionBarTitle(title)

        rvSepatu = findViewById(R.id.grid)
        rvSepatu.setHasFixedSize(true)

        list.addAll(DataSepatu.listData)
        showRecyclerGrid()

    }
    private fun showRecyclerGrid(){
        rvSepatu.layoutManager= GridLayoutManager(this,2)
        val gridSepatuAdapter = GridSepatuAdapter(list)
        rvSepatu.adapter = gridSepatuAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }


    private fun setMode(selectedMode:Int){
        when(selectedMode){
            R.id.grid ->{
                title="Mode Grid"
                showRecyclerGrid()
            }
            R.id.cardview ->{
                title="CardView"
                showRecyclerCardView()
            }
        }
    }

    private fun showRecyclerCardView(){
        rvSepatu.layoutManager = LinearLayoutManager(this)
        val cardViewSepatuAdapter =CardViewSepatuAdapter(list)
        rvSepatu.adapter = cardViewSepatuAdapter

    }

    private fun setActionBarTitle(title:String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showSelectedSepatu(sepatu: Sepatu){
        Toast.makeText(this, "Kamu Memilih"+sepatu.name, Toast.LENGTH_SHORT).show()
    }

    }
