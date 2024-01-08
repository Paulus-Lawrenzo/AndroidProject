package com.mandiri.appmandiri.presentation.message.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.adapter.HistoryTransactionAdapter
import com.mandiri.appmandiri.databinding.FragmentHistoryTransactionBinding
import com.mandiri.appmandiri.model.HistoryTransactionModel
import com.mandiri.appmandiri.utils.ConfirmationDialogUtil

class HistoryTransactionFragment : Fragment() {
    private var _binding: FragmentHistoryTransactionBinding? = null
    private val binding get() = _binding!!
    private var _historyAdapter: HistoryTransactionAdapter? = null
    private var _historyTransactionData: List<HistoryTransactionModel>? = null
    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTransactionBinding.inflate(inflater, container, false)
        setupViewHistoryTransaction()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirmationDialogUtil = ConfirmationDialogUtil(requireContext())

        setupViewHistoryTransaction()

        val items = arrayOf("Semua", "Debit", "Credit")
        binding.spFilterTransaction.adapter =
            ArrayAdapter(requireContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item, items)

        binding.spFilterTransaction.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerValue = parent?.getItemAtPosition(position).toString()
                binding.tvFilterName.text = spinnerValue

                if (spinnerValue == "Semua") {
                    _historyAdapter?.filterTransactionData(populateDataHistoryTransaction())
                } else {
                    populateDataHistoryTransaction()
                        .filter {
                            it.titleTransaction == spinnerValue.lowercase() }
                        .also {
                                historyData -> _historyAdapter?.filterTransactionData(historyData)
                        }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun setupViewHistoryTransaction() {
        _historyTransactionData = populateDataHistoryTransaction()
        _historyAdapter = HistoryTransactionAdapter(
            data = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {dataTransaction ->
                confirmationDialogUtil.showConfirmationDialog(
                    title = dataTransaction.titleTransaction,
                    icon = dataTransaction.iconTransaction,
                    onConfirm = {
                        DetailTransactionActivity.navigateToDetailTransaction(
                            activity = requireActivity(),
                            dataTransaction
                        )
                    },
                    onCancel = {

                    })
            }
        )
        binding.rvTransaction.adapter = _historyAdapter
    }

    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel> {
        return listOf(
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 1,
                iconTransaction = R.drawable.baseline_arrow_right_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 2,
                iconTransaction = R.drawable.baseline_account_circle_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 3,
                iconTransaction = R.drawable.baseline_copyright_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 2,
                iconTransaction = R.drawable.baseline_account_circle_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 2,
                iconTransaction = R.drawable.baseline_account_circle_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 2,
                iconTransaction = R.drawable.baseline_account_circle_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Uang tunai sudah masuk",
                balanceTransaction = "Rp 200.000",
                statusTransaction = 3,
                iconTransaction = R.drawable.baseline_copyright_24
            ),
            HistoryTransactionModel(
                date = "3 Januari 2024",
                titleTransaction = "credit",
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