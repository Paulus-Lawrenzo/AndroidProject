package com.mandiri.appmandiri.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.model.EwalletModel
import com.mandiri.appmandiri.model.MenuModel
import com.mandiri.appmandiri.model.SavingDepositModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _homeMenu = MutableLiveData<List<MenuModel>>()
    val homeMenu: LiveData<List<MenuModel>>
        get() = _homeMenu

    private val _ewalletData = MutableLiveData<MutableList<EwalletModel>>()
    val ewalletData: LiveData<MutableList<EwalletModel>>
        get() = _ewalletData

    private val _savingDepositData = MutableLiveData<MutableList<SavingDepositModel>>()
    val savingDepositData: LiveData<MutableList<SavingDepositModel>>
        get() = _savingDepositData

    // Function to set up menu data
    fun setMenuData() = viewModelScope.launch {
        _homeMenu.postValue(populateDataMenuHome())
    }

    // Function to set up ewallet data
    fun setEwalletData() = viewModelScope.launch {
        _ewalletData.postValue(populateDataEwallet())
    }

    // Function to set up saving deposit data
    fun setSavingDepositData() = viewModelScope.launch {
        _savingDepositData.postValue(populateSavingDepositData())
    }

//    // Function to handle ewallet item click
//    fun onEwalletItemClicked(ewallet: EwalletModel) {
//        // Perform actions here when an ewallet item is clicked
//    }

    // Function to populate ewallet data (similar to your previous code)
    private fun populateDataEwallet(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gopay", image = R.drawable.ic_gopay, balance = 100000.0, isConnected = true),
            EwalletModel(name = "Shopee", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false),
            EwalletModel(name = "LinkAja", image = R.drawable.ic_linkaja, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Ovo", image = R.drawable.ic_ovo, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_dana, balance = 100000.0, isConnected = false),
            EwalletModel(name = "AstraPay", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false)
        )
    }

    // Function to populate saving deposit data (similar to your previous code)
    private fun populateSavingDepositData(): MutableList<SavingDepositModel> {
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

    // Function to populate menu data (similar to your previous code)
    private fun populateDataMenuHome(): List<MenuModel> {
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
}