package com.example.languageapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class settings_activity : AppCompatActivity() {
    lateinit var myPreference: MyPreference
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        context = this
        myPreference = MyPreference(this)

        val btnreturn: Button = findViewById(R.id.btnReturn)

        val languageSpinner: Spinner = findViewById(R.id.languageSpinner)

        // Populate the spinner with language options
        val languages = arrayOf("en", "af", "zh" , "ja" , "ko") // Add your supported languages here
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter

        val lang = myPreference.getLoginCount()
        val index = languages.indexOf(lang)
        if(index >= 0){
            languageSpinner.setSelection(index)
        }

        btnreturn.setOnClickListener(){
            myPreference.setLoginCount(languages[languageSpinner.selectedItemPosition])
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}