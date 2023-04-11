package com.example.activityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private val launcher = registerForActivityResult(FruitResultContract()){ fruit ->
        resultTextView.text = fruit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.input_name)
        resultTextView = findViewById(R.id.result_text)

        val button = findViewById<Button>(R.id.my_button)
        button.setOnClickListener {
            val name = editText.text.toString()
            launcher.launch(name)
        }
    }
}

class FruitResultContract : ActivityResultContract<String, String>() {

    override fun createIntent(context: Context, name: String): Intent {
        val intent = Intent(context, FruitActivity::class.java)
        intent.putExtra("key_name", name)
        return intent
    }


    override fun parseResult(resultCode: Int, intent: Intent?): String {
        if (resultCode != Activity.RESULT_OK) {
            return "oops"
        }
        return intent?.getStringExtra("result_fruit")!!
    }

}