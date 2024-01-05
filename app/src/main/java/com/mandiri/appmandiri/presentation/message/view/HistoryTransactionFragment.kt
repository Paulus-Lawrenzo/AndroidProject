package com.mandiri.appmandiri.presentation.message.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.adapter.HistoryTransactionAdapter
import com.mandiri.appmandiri.databinding.FragmentHistoryTransactionBinding
import com.mandiri.appmandiri.model.HistoryTransactionModel

class HistoryTransactionFragment : Fragment() {
    private var _binding: FragmentHistoryTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTransactionBinding.inflate(inflater, container, false)
        setupViewHistoryTransaction()
        return binding.root
    }

    private fun setupViewHistoryTransaction() {
        binding.rvTransaction.adapter = HistoryTransactionAdapter(
            data = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = it
                )
            }
        )
    }

    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel> {
        return listOf(
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "Credit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 1,
                iconTransaction = R.drawable.baseline_arrow_right_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "Debit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 2,
                iconTransaction = R.drawable.baseline_account_circle_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "Credit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 3,
                iconTransaction = R.drawable.baseline_copyright_24
            ),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}