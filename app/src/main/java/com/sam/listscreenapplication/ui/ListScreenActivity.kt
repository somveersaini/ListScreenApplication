package com.sam.listscreenapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sam.listscreenapplication.R

class ListScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_screen_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListScreenFragment.newInstance())
                .commitNow()
        }
    }
}
