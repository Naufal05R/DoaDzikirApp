package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoaDzikirAdapter
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.databinding.ActivitySetiapSaatDzikirBinding

class SetiapSaatDzikirActivity : AppCompatActivity() {

    private var _binding: ActivitySetiapSaatDzikirBinding? = null
    private val binding get() = _binding as ActivitySetiapSaatDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikir)
        binding.rvDzikirSetiapSaat.adapter = mAdapter
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)
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