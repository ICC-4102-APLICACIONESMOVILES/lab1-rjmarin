package com.example.lab1_raimundo_marin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.regex.Pattern


class Login : AppCompatActivity() {

     val EMAIL_ADDRESS_PATTERN = Pattern.compile(
         "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
         "\\@" +
         "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
         "(" +
         "\\." +
         "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
         ")+"
)

    private fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var email = findViewById(R.id.email) as EditText
        var password = findViewById(R.id.password) as EditText
        var btnLogin = findViewById(R.id.Login) as Button

        btnLogin.setOnClickListener {
            val temail = email.text.toString();
            val tpass = password.text.toString();
            if (checkEmail(temail)){

                Toast.makeText(this@Login, "Correct", Toast.LENGTH_LONG).show()
                val intent = Intent(this@Login,MainActivity::class.java)
                intent.putExtra("email",temail)
                intent.putExtra("password",tpass)
                startActivity(intent)

            }
            else{
                Toast.makeText(this@Login, "Incorrect", Toast.LENGTH_LONG).show()
                email.setText("")
                password.setText("")
            }


        }
    }

}
