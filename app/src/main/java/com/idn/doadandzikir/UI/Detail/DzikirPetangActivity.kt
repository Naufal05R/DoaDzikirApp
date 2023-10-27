package com.idn.doadandzikir.UI.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoaDzikirAdapter
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.databinding.ActivityDzikirPetangBinding

class DzikirPetangActivity : AppCompatActivity() {

    private var _binding: ActivityDzikirPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Petang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DoaDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}