package com.pateljay012347.group_scorelab21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

//// the class is made and extends and implemantation
class MainActivity : AppCompatActivity(), View.OnClickListener {

    /// The class has three private variables
    private var scoreTeam1 = 0
    private var scoreTeam2 = 0
    private var incrementValue = 1

    /// can respond to click events by implemantation
    private lateinit var scoreTextViewTeam1: TextView
    private lateinit var scoreTextViewTeam2: TextView
    //// method, the activity layout is set using
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ////The class also has two private variables
        scoreTextViewTeam1 = findViewById(R.id.Team_1_Score)
        scoreTextViewTeam2 = findViewById(R.id.Team_2_Score)

        findViewById<Button>(R.id.inc_button_team_1).setOnClickListener(this)
        findViewById<Button>(R.id.inc_button_team_2).setOnClickListener(this)
        findViewById<Button>(R.id.dec_button_team_1).setOnClickListener(this)
        findViewById<Button>(R.id.dec_button_team_2).setOnClickListener(this)
        val switch: Switch = findViewById(R.id.darkmode)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        // Find the RadioGroup and set an OnCheckedChangeListener
        findViewById<RadioGroup>(R.id.diff_values).setOnCheckedChangeListener { group, checkedId ->
            // Find the RadioButton that was checked and update the increment value
            val radioButton = group.findViewById<RadioButton>(checkedId)
            incrementValue = radioButton.text.toString().toInt()
            Log.i("onCheckedChanged", "Increment value set to: $incrementValue")
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        Log.i("onClick", "A button was pressed")
        /// maximun score and minimum  score
        when(v?.id) {
            R.id.inc_button_team_1 -> {
                scoreTeam1 += incrementValue
                if (scoreTeam1 > 300) {
                    scoreTeam1 = 300
                }
                scoreTextViewTeam1.text = scoreTeam1.toString()
                Log.i("onClick", "Increase Team 1 by $incrementValue")
            }
            //// it updates the text of scoreTextViewTeam2 to display the updated score of Team 2 and logs the action taken and the new score using Log.i.
            R.id.inc_button_team_2 -> {
                scoreTeam2 += incrementValue
                if (scoreTeam2 > 300) {
                    scoreTeam2 = 300
                }
                scoreTextViewTeam2.text = scoreTeam2.toString()
                Log.i("onClick", "Increase Team 2 by $incrementValue")
            }
            ////A log message is printed to record the action taken and the amount of decrement.
            R.id.dec_button_team_1 -> {
                scoreTeam1 -= incrementValue
                if (scoreTeam1 < 0) {
                    scoreTeam1 = 0
                }
                scoreTextViewTeam1.text = scoreTeam1.toString()
                Log.i("onClick", "Decrease Team 1 by $incrementValue")
            }
            /// This the part of where the score cannot go below 0
            R.id.dec_button_team_2 -> {
                scoreTeam2 -= incrementValue
                if (scoreTeam2 < 0) {
                    scoreTeam2 = 0
                }
                scoreTextViewTeam2.text = scoreTeam2.toString()
                Log.i("onClick", "Decrease Team 2 by $incrementValue")
            }
            else -> Log.e("onClick", "Something went wrong in OnCLick method")
        }
    }
}