package com.mandiri.appmandiri.presentation

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.databinding.HomeMainActivityBinding
import com.mandiri.appmandiri.helper.SharedPref
import com.mandiri.appmandiri.presentation.home.HomeFragment
import com.mandiri.appmandiri.presentation.message.MessageFragment
import com.mandiri.appmandiri.utils.ConfirmationDialogUtil

class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: HomeMainActivityBinding
    private lateinit var sharedPref: SharedPref
    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationPromo -> {
                    replaceFragment(PromoFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationSetting -> {
                    replaceFragment(SettingFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = SharedPref(this)
        confirmationDialogUtil = ConfirmationDialogUtil(this)


        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun showConfirmation() {
        val title = "Konfirmasi"
        val icon = R.drawable.baseline_account_circle_24

        confirmationDialogUtil.showConfirmationDialog(
            title,
            icon,
            onConfirm = {
                logout()
            },
            onCancel = {

            }
        )
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("Apakah anda yakin")
            .setMessage("Ingin keluar dari livin?")
            .setPositiveButton("Ya") { _: DialogInterface, _: Int ->
                logout()
            }.setNegativeButton("Tidak") { _: DialogInterface, _: Int ->

            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun logout() {
        sharedPref.clearDataPref()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}