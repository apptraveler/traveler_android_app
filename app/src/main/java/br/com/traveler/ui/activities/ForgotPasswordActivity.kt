package br.com.traveler.ui.activities

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import br.com.traveler.R
import android.text.TextUtils
import android.util.Patterns


class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recoverButton = findViewById<AppCompatButton>(R.id.recover_password_button)
        recoverButton.setOnClickListener {
            recoverPassword()
        }
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        target.let { return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(it).matches() }
    }

    private fun recoverPassword() {

        val emailEditText = findViewById<EditText>(R.id.forgot_email).text.toString().trim()
        val isValidEmail = isValidEmail(emailEditText)

        val toastSuccess = Toast.makeText(this, "E-mail de recuperação enviado", Toast.LENGTH_LONG)
        val toastRequired = Toast.makeText(this, "O campo E-mail está inválido ou em branco", Toast.LENGTH_LONG)

        if (isValidEmail) {
            toastSuccess.show()
        } else {
            toastRequired.show()
        }


    }
}