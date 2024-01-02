package com.mandiri.appmandiri

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.appmandiri.adapter.EwalletAdapter
import com.mandiri.appmandiri.adapter.SavingDepositAdapter
import com.mandiri.appmandiri.databinding.ActivityHomeBinding
import com.mandiri.appmandiri.model.EwalletModel
import com.mandiri.appmandiri.model.SavingDepositModel

class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewWallet()
        setUpViewSavingDeposit()
    }
    private fun setUpViewWallet(){
        dummyEwalletList = createDummyEwalletList()

        binding.componentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet {Ewallet ->
            Toast.makeText(this, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()
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
            EwalletModel(name = "Ovo", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false)
        )
    }

    private fun setUpViewSavingDeposit(){
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = SavingDepositAdapter(populateSavingDepositData())
    }
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
}