package br.com.traveler.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import br.com.traveler.R
import br.com.traveler.ui.adapters.LoginAdapter
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureFragments()
    }

    private fun configureFragments() {
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)

        with(tabLayout) {
            addTab(newTab().setText("Login"))
            addTab(newTab().setText("Signup"))
            tabGravity = TabLayout.GRAVITY_FILL
        }

        val adapter = LoginAdapter(supportFragmentManager, this, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}