package com.mandiri.appmandiri.presentation.message.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.appmandiri.databinding.ActivityDetailTransactinBinding

class DetailTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTransactinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.componentToolbar.tvToolbarTitle.text = "Detail History"
    }
}