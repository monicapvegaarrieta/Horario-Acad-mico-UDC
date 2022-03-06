package com.monica.horarioacadmicoudc

import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.monica.horarioacadmicoudc.databinding.ActivityAddSubjectBinding

class AddSubjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddSubjectBinding
    var selectedTeacher = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddSubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = MainActivity.instance?.getSharedPreferences("Database", Context.MODE_PRIVATE)
        val subjectCount = sharedPref!!.getInt("subject_count", 0)
        binding.btnAdd.setOnClickListener {
            if (binding.txtName.text.toString() != "") {
                with(sharedPref.edit()) {
                    putString("subject_name_$subjectCount",binding.txtName.text.toString())
                    putInt("subject_weekly_hour_$subjectCount",binding.txtWeeklyHour.text.toString().toInt())
                    putInt("subject_total_hours_$subjectCount",binding.txtTotalHour.text.toString().toInt())
                    putInt("subject_teacher_id_$subjectCount",selectedTeacher)
                    putInt("subject_count", subjectCount + 1)
                    apply()
                }

                finish()
            }
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