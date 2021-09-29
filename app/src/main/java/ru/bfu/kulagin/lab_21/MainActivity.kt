package ru.bfu.kulagin.lab_21


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView



import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ru.bfu.kulagin.lab_21.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(HomeFragment())
        setupBottomNavigationBar();

    }

    private fun setupBottomNavigationBar() {
        val bot_navigation : BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bot_nav)
        bot_navigation!!.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {openFragment(EventsFragment())
                    true}
                R.id.page_2 -> {openFragment(HolidayFragment())
                    true}
                R.id.page_3 -> {openFragment(ProfileFragment())
                    true}
                else -> true
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_home, fragment)
            .addToBackStack(null)
            .commit()
    }
}

