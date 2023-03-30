package com.example.uklproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class RegisterFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_fragment)

        val view_pager : ViewPager = findViewById(R.id.view_pager)
        val tabs : TabLayout = findViewById(R.id.tabs)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }
}