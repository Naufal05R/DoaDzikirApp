package com.idn.doadandzikir.UI.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoaDzikirAdapter
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityDzikirPagiBinding
import com.idn.doadandzikir.databinding.ActivityHarianDzikirDoaBinding

class DzikirPagiActivity : AppCompatActivity() {

    private var _binding: ActivityDzikirPagiBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
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