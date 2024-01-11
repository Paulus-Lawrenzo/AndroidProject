package com.mandiri.appmandiri.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentSettingBinding
import com.mandiri.appmandiri.helper.SharedPrefHelper
import com.mandiri.appmandiri.utils.ConfirmationDialogUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding {
        return FragmentSettingBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        confirmationDialogUtil = ConfirmationDialogUtil(requireContext())
        binding.componentSettingLogout.llLogout.setOnClickListener {
            showConfirmation()
        }
    }

    private fun logout() {
        sharedPrefHelper.clearDataPref()
        startActivity(Intent(requireContext(), LoginActivity::class.java))
    }

    private fun showConfirmation() {
        val title = "Konfirmasi"
        val icon = R.drawable.ic_run_livin
        confirmationDialogUtil.showConfirmationDialog(
            title,
            icon,
            isOnHistoryTransaction = false,
            onConfirm = {
                logout()
            },
            onCancel = {

            }
        )
    }
}