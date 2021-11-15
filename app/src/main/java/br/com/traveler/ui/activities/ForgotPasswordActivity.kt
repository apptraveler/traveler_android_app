package br.com.traveler.ui.activities

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import br.com.traveler.R

class ForgotPasswordActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recoverPassword()
    }

    fun recoverPassword() {
        val recoverButton = findViewById<AppCompatButton>(R.id.recover_password_button)
        recoverButton.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.forgot_email)
            val toastSuccess = Toast.makeText(this, "E-mail de recuperação enviado", Toast.LENGTH_LONG)
            val toastRequired = Toast.makeText(this, "O campo E-mail está inválido ou em branco", Toast.LENGTH_LONG)
            if(emailEditText.text.toString().trim().isNotEmpty()) {
                toastSuccess.show()
            } else {
                toastRequired.show()
            }
        }
    }
}