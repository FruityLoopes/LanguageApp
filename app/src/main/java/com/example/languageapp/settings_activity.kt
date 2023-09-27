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

        // Populate the spinner with language options "English", "Afrikaans", "中国人" , "日本語" , "한국인"
        val languages = arrayOf("English", "Afrikaans", "中国人" , "日本語" , "한국인") // Add your supported languages here
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter

        val lang = myPreference.getLoginCount()
        val index = languages.indexOf(lang)
        if(index >= 0){
            languageSpinner.setSelection(index)
        }

        btnreturn.setOnClickListener(){
           if( languages[languageSpinner.selectedItemPosition] == "English"){
               myPreference.setLoginCount("en")
               startActivity(Intent(this,MainActivity::class.java))
               finish()
           } else if(languages[languageSpinner.selectedItemPosition] == "Afrikaans"){
               myPreference.setLoginCount("af")
               startActivity(Intent(this,MainActivity::class.java))
               finish()
           } else if( languages[languageSpinner.selectedItemPosition] == "日本語"){
               myPreference.setLoginCount("ja")
               startActivity(Intent(this,MainActivity::class.java))
               finish()
           } else if(languages[languageSpinner.selectedItemPosition] == "中国人"){
               myPreference.setLoginCount("zh")
               startActivity(Intent(this,MainActivity::class.java))
               finish()
           } else if(languages[languageSpinner.selectedItemPosition] == "한국인") {
               myPreference.setLoginCount("ko")
               startActivity(Intent(this,MainActivity::class.java))
               finish()
           }

        }
    }
}