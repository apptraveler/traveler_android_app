package br.com.traveler.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import br.com.traveler.R
import br.com.traveler.models.User
import br.com.traveler.models.UserCreated
import br.com.traveler.services.RetrofitInitializer
import br.com.traveler.ui.activities.ForgotPasswordActivity
import br.com.traveler.ui.activities.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_tab_fragment, container, false)

        view?.let { configureAnimations(it) }

        view.findViewById<TextView>(R.id.forgot_password_button).setOnClickListener {
            navigateToForgotPasswordActivity()
        }

        view.findViewById<Button>(R.id.login_button).setOnClickListener {
            val emailText = view.findViewById<TextView>(R.id.email)
            val passwordText = view.findViewById<TextView>(R.id.name)

            signIn(emailText.text.toString(), passwordText.text.toString())
        }

        return view
    }

    private fun configureAnimations(view: View) {
        val v = 0f

        val email = view.findViewById<EditText>(R.id.email)
        val password = view.findViewById<EditText>(R.id.name)
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
    }

    private fun navigateToForgotPasswordActivity() {
        val intent = Intent(activity, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    private fun signIn(email: String, password: String) {
        val authenticationService = RetrofitInitializer().getAuthorizationService()
        val call = authenticationService.signIn(User(email, password))

        call.enqueue(object : Callback<UserCreated> {
            override fun onResponse(call: Call<UserCreated>, response: Response<UserCreated>) {
                if (!response.isSuccessful) {
                    val toastInvalidLogin = Toast.makeText(activity, "Usuário e/ou senha inválidos", Toast.LENGTH_LONG)
                    toastInvalidLogin.show()
                    return
                }

                goToHome()
            }

            override fun onFailure(call: Call<UserCreated>, t: Throwable) {
                val toastInvalidLogin = Toast.makeText(activity, "Serviço indisponível", Toast.LENGTH_LONG)
                toastInvalidLogin.show()
            }
        })
    }

    private fun goToHome() {
        with(activity) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}