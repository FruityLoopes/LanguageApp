package com.example.languageapp

import android.content.res.Configuration
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languageSpinner: Spinner = findViewById(R.id.languageSpinner)

        // Populate the spinner with language options
        val languages = arrayOf("en", "af") // Add your supported languages here
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter

        

          // Set a listener to handle language selection
         languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
              override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                  val selectedLanguage = languages[position]
                  val locale = Locale(selectedLanguage)
                  Locale.setDefault(locale)
                  val config = Configuration()
                  config.locale = locale
                  baseContext.resources.updateConfiguration(
                      config,
                      baseContext.resources.displayMetrics
                  )
              }

              override fun onNothingSelected(parent: AdapterView<*>?) {
                  // Do nothing
              }
          }

    }



}
