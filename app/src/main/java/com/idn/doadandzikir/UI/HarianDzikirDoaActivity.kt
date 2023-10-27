package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoaDzikirAdapter
import com.idn.doadandzikir.Model.DoaDzikirItem
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityHarianDzikirDoaBinding

class HarianDzikirDoaActivity : AppCompatActivity() {

    private var _binding: ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirData()
        initView()
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

    private fun initView() {
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvDzikirDoaHarian.adapter = mAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirData(): List<DoaDzikirItem> {
        val judulDoa = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val isiDoa = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahDoa = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (i in judulDoa.indices) {
            val data = DoaDzikirItem(
                judulDoa[i],
                isiDoa[i],
                terjemahDoa[i],
            )
            listData.add(data)
        }
        return listData
    }
}