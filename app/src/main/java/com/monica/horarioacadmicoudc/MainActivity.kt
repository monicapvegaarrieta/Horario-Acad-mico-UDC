package com.monica.horarioacadmicoudc

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.monica.horarioacadmicoudc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object {
        var instance: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        instance = this@MainActivity

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.btnSubject.setOnClickListener {
            val intent = Intent(this@MainActivity, SubjectsActivity::class.java);
            startActivity(intent);
        }
        binding.btnTeachers.setOnClickListener {
            val intent = Intent(this@MainActivity, TeachersActivity::class.java);
            startActivity(intent);
        }
        binding.btnSchedule.setOnClickListener {
            val intent = Intent(this@MainActivity, SchedulesActivity::class.java);
            startActivity(intent);
        }
        binding.btnProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, EditProfileActivity::class.java);
            startActivity(intent);
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}