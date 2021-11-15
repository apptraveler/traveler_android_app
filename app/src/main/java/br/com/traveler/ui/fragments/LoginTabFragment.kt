package br.com.traveler.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import br.com.traveler.R
import br.com.traveler.ui.activities.ForgotPasswordActivity

class LoginTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_tab_fragment, container, false)

        val v = 0f

        val email = view.findViewById<EditText>(R.id.email)
        val password = view.findViewById<EditText>(R.id.password)
        val forgotPasswordButton = view.findViewById<TextView>(R.id.forgot_password_button)
        val loginButton = view.findViewById<AppCompatButton>(R.id.login_button)
        val backgroundImage = view.findViewById<ImageView>(R.id.login_background_image)

        if (email != null) {
            email.translationX = 800F
            email.alpha = v
            email.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(500).start()
        }
        if (password != null) {
            password.translationX = 800F
            password.alpha = v
            password.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(500).start()
        }
        if (forgotPasswordButton != null) {
            forgotPasswordButton.translationX = 800F
            forgotPasswordButton.alpha = v
            forgotPasswordButton.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(500).start()
        }
        if (loginButton != null) {
            loginButton.translationX = 800F
            loginButton.alpha = v
            loginButton.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(500).start()
        }
        if (backgroundImage != null) {
            backgroundImage.translationX = 800F
            backgroundImage.alpha = v
            backgroundImage.animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(500).start()
        }

        view.findViewById<TextView>(R.id.forgot_password_button).setOnClickListener {
            navigateToForgotPasswordActivity()
        }

        return view
    }

    private fun navigateToForgotPasswordActivity() {
        val intent = Intent(activity, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }
}