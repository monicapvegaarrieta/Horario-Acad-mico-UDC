package com.monica.horarioacadmicoudc

import android.app.Application
import android.content.Context
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.monica.horarioacadmicoudc.databinding.ActivitySubjectsBinding

class SubjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@SubjectsActivity, AddSubjectActivity::class.java);
            startActivity(intent);
        }

    }

    override fun onResume() {
        super.onResume()

        val sharedPref = MainActivity.instance?.getSharedPreferences("Database", Context.MODE_PRIVATE)
        val subjectCount = sharedPref!!.getInt("subject_count", 0)
        var subjects = arrayListOf<SubjectItem>()
        var index = 0;
        while (index < subjectCount) {
            subjects.add(SubjectItem(
                index,
                sharedPref.getString("subject_name_$index", ""),
                sharedPref.getInt("subject_weekly_hours_$index",0),
                sharedPref.getInt("subject_total_hours_$index",0),
                sharedPref.getInt("subject_teacher_id_$index",0),
            ))
            index++
        }

        print(subjects)

        binding.recyclerView.adapter = SubjectAdapter(subjects)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

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