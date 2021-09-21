package com.z4r17.mentorinApp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.z4r17.mentorinApp.Adapter.GridMentorAdapter
import com.z4r17.mentorinApp.Adapter.ListMentorAdapter
import com.z4r17.mentorinApp.Mentor
import com.z4r17.mentorinApp.MentorData
import com.z4r17.mentorin.R
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvMentor: RecyclerView
    private var list: ArrayList<Mentor> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "MentorIn"

        rvMentor = findViewById(R.id.rv_mentor)
        rvMentor.setHasFixedSize(true)

        list.addAll(MentorData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMentor.layoutManager = LinearLayoutManager(this)
        val listMentorAdapter = ListMentorAdapter(list)
        rvMentor.adapter = listMentorAdapter

    }

    private fun showRecyclerGrid(){
        rvMentor.layoutManager = GridLayoutManager(this, 2)
        val gridMentorAdapter = GridMentorAdapter(list)
        rvMentor.adapter = gridMentorAdapter

        gridMentorAdapter.setOnItemClickCallback(object : GridMentorAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Mentor) {
                showSelectedMentor(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedMentor(mentor: Mentor) {
        Toast.makeText(this, "Kamu memilih " + mentor.name, Toast.LENGTH_SHORT).show()
    }


    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.profile -> {
                val toAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(toAbout)
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_list -> {
                showRecyclerList()
            }
        }
    }
}