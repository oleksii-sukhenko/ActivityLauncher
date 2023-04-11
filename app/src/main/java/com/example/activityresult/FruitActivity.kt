package com.example.activityresult

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FruitActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        val textView = findViewById<TextView>(R.id.name_text)

        val nameText = intent.getStringExtra("key_name")
        textView.text = nameText

        val appleButton = findViewById<Button>(R.id.apple_button)
        val bananaButton = findViewById<Button>(R.id.banana_button)

        appleButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result_fruit", "Apple")
            setResult(RESULT_OK, intent)
            finish()
        }

        bananaButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result_fruit", "Banana")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}