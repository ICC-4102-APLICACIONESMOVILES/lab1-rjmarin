package com.example.lab1_raimundo_marin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ButtonLogin = findViewById(R.id.ButtonLogin) as Button
        var text_email = findViewById(R.id.t_email) as TextView
        var text_password = findViewById(R.id.t_password) as TextView
        val profileEmail=intent.getStringExtra("email")
        val profilePassword=intent.getStringExtra("password")
        if (profileEmail!=""){
            text_email.setText("email: "+profileEmail)
            text_password.setText("password: "+profilePassword)

        }
        else{
            val intent = Intent(this@MainActivity,Login::class.java)
            startActivity(intent)

        }

        ButtonLogin.setOnClickListener {
            text_email.setText("")
            text_password.setText("")
            val intent = Intent(this@MainActivity,Login::class.java)
            startActivity(intent)

        }





    }

}
