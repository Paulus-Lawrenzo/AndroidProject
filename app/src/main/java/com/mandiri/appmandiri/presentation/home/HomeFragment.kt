package com.mandiri.appmandiri.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.adapter.EwalletAdapter
import com.mandiri.appmandiri.adapter.MenuHomeAdapter
import com.mandiri.appmandiri.adapter.SavingDepositAdapter
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentHomeBinding
import com.mandiri.appmandiri.model.EwalletModel
import com.mandiri.appmandiri.model.MenuModel
import com.mandiri.appmandiri.model.SavingDepositModel
import com.mandiri.appmandiri.presentation.home.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var menuAdapter: MenuHomeAdapter
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setMenuData()
        viewModel.setEwalletData()
        viewModel.setSavingDepositData()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setUpViewMenu(it)
        }
        viewModel.ewalletData.observe(viewLifecycleOwner) {
            setUpViewWallet(it)
        }
        viewModel.savingDepositData.observe(viewLifecycleOwner) {
            setUpViewSavingDeposit(it)
        }
    }

    private fun setUpViewWallet(data: MutableList<EwalletModel>){
        dummyEwalletList = data
        binding.componentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet {Ewallet ->
            Toast.makeText(activity, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()
            dummyEwalletList?.forEach{
                if (it.name == Ewallet.name) it.isConnected=true
            }
            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }

    private fun setUpViewSavingDeposit(data: MutableList<SavingDepositModel>){
        savingDepositAdapter = SavingDepositAdapter(data)
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(data)
    }

    private fun updateSizeSavingDeposit(data: MutableList<SavingDepositModel>){
        binding.componentHomeSavingDeposit.llShowMore.isVisible = data.size > 2
        binding.componentHomeSavingDeposit.llShowMore.setOnClickListener{
            savingDepositAdapter.updateQuantityDepositSize(data.size)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.GONE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.VISIBLE
        }
        binding.componentHomeSavingDeposit.llShowLess.setOnClickListener{
            savingDepositAdapter.updateQuantityDepositSize(2)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.VISIBLE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.GONE
        }
    }


    private fun setUpViewMenu(data: List<MenuModel>){
        menuAdapter = MenuHomeAdapter(data)
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            Toast.makeText(activity, "${it.menuTitle}", Toast.LENGTH_SHORT).show()
        }
    }
}