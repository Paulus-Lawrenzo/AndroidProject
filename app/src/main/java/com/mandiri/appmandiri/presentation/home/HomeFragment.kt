package com.mandiri.appmandiri.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
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
import com.mandiri.appmandiri.presentation.viewmodel.NotificationViewModel

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
        setUpViewWallet()
        setUpViewSavingDeposit()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setUpViewMenu(it)
        }
        viewModel.ewalletData.observe(viewLifecycleOwner) {
            setUpViewWallet()
        }
        viewModel.savingDepositData.observe(viewLifecycleOwner) {
            setUpViewSavingDeposit()
        }
    }

    private fun setUpViewWallet(){
        dummyEwalletList = createDummyEwalletList()
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
    private fun createDummyEwalletList(): MutableList<EwalletModel>{
        return mutableListOf(
            EwalletModel(name = "Gopay", image = R.drawable.ic_gopay, balance = 100000.0, isConnected = true),
            EwalletModel(name = "Shopee", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false),
            EwalletModel(name = "LinkAja", image = R.drawable.ic_linkaja, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Ovo", image = R.drawable.ic_ovo, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_dana, balance = 100000.0, isConnected = false),
            EwalletModel(name = "AstraPay", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false)
        )
    }

    private fun setUpViewSavingDeposit(){
        savingDepositAdapter = SavingDepositAdapter(populateSavingDepositData())
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(populateSavingDepositData())
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

    // move to viewModel
    private fun populateSavingDepositData(): MutableList<SavingDepositModel>{
        return mutableListOf(
            SavingDepositModel(
                savingName = "Tabungan IDR NOW",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Nikah",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Rumah",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Jajan",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Anak",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
        )
    }


    // move to viewModel
    private fun populateDataMenuHome(): List<MenuModel>{
        return listOf(
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Transfer"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Donasi"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "QR"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Cashsles"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "E-Wallet"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Tarik"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Bayar"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Setor"
            )
        )
    }
    private fun setUpViewMenu(data: List<MenuModel>){
        menuAdapter = MenuHomeAdapter(data)
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            Toast.makeText(activity, "${it.menuTitle}", Toast.LENGTH_SHORT).show()
        }
    }
}