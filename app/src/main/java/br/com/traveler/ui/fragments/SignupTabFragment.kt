package br.com.traveler.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.traveler.R
import br.com.traveler.models.User
import br.com.traveler.models.UserCreated
import br.com.traveler.services.RetrofitInitializer
import br.com.traveler.ui.activities.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signup_tab_fragment, container, false)

        view.findViewById<Button>(R.id.registerButton).setOnClickListener {
            val emailText = view.findViewById<TextView>(R.id.email)
            val nameText = view.findViewById<TextView>(R.id.name)
            val passwordText = view.findViewById<TextView>(R.id.password)

            signUp(nameText.text.toString(), emailText.text.toString(), passwordText.text.toString())
        }

        return view
    }

    private fun signUp(name: String, email: String, password: String) {
        val authenticationService = RetrofitInitializer().getAuthorizationService()
        val call = authenticationService.signUp(User(email, password, name))

        call.enqueue(object : Callback<UserCreated> {
            override fun onResponse(call: Call<UserCreated>, response: Response<UserCreated>) {
                if (!response.isSuccessful) {
                    val toastInvalidRegister = Toast.makeText(activity, "Usuário e/ou senha inválidos", Toast.LENGTH_LONG)
                    toastInvalidRegister.show()
                    return
                }

                val toastRegisterSuccess = Toast.makeText(activity, "Usuário $name criado com sucesso", Toast.LENGTH_LONG)
                toastRegisterSuccess.show()
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