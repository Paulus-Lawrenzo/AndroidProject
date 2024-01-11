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
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _homeMenu = MutableLiveData<List<MenuModel>>()
    val homeMenu: LiveData<List<MenuModel>>
        get() = _homeMenu

    private val _ewalletData = MutableLiveData<List<EwalletModel>>()
    val ewalletData: LiveData<List<EwalletModel>>
        get() = _ewalletData

    private val _savingDepositData = MutableLiveData<List<SavingDepositModel>>()
    val savingDepositData: LiveData<List<SavingDepositModel>>
        get() = _savingDepositData

    // Function to set up menu data
    fun setMenuData() {
        val menuData = populateDataMenuHome()
        _homeMenu.value = menuData
    }

    // Function to set up ewallet data
    fun setEwalletData() {
        val ewalletData = createDummyEwalletList()
        _ewalletData.value = ewalletData
    }

    // Function to set up saving deposit data
    fun setSavingDepositData() {
        val savingDepositData = populateSavingDepositData()
        _savingDepositData.value = savingDepositData
    }

    // Function to handle ewallet item click
    fun onEwalletItemClicked(ewallet: EwalletModel) {
        // Perform actions here when an ewallet item is clicked
    }

    // Function to populate ewallet data (similar to your previous code)
    private fun createDummyEwalletList(): List<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gopay", image = R.drawable.ic_gopay, balance = 100000.0, isConnected = true),
            // ... other ewallet data
        )
    }

    // Function to populate saving deposit data (similar to your previous code)
    private fun populateSavingDepositData(): List<SavingDepositModel> {
        return mutableListOf(
            SavingDepositModel(savingName = "Tabungan IDR NOW", accountNumber = "17432748372478", imageCard = R.drawable.ic_card_rek),
            // ... other saving deposit data
        )
    }

    // Function to populate menu data (similar to your previous code)
    private fun populateDataMenuHome(): List<MenuModel> {
        return listOf(
            MenuModel(image = R.drawable.ic_circle, menuTitle = "Transfer"),
            // ... other menu data
        )
    }

}