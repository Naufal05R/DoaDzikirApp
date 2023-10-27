package com.idn.doadandzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.doadandzikir.Adapter.ArtikelAdapter
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.UI.Detail.DetailArticleActivity
import com.idn.doadandzikir.UI.HarianDzikirDoaActivity
import com.idn.doadandzikir.UI.PagiPetangDzikirActivity
import com.idn.doadandzikir.UI.QauliyahShalatActivity
import com.idn.doadandzikir.UI.SetiapSaatDzikirActivity
import com.idn.doadandzikir.Utils.OnItemCallback

class MainActivity : AppCompatActivity() {
    private var keep = true
    private val runner = Runnable { keep = false }

    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for (i in 0 until listArtikel.size) {
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }
            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    private lateinit var sliderIndicator: Array<ImageView?>

    private lateinit var vpArtikel: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
            .setKeepOnScreenCondition { keep }

        Handler(Looper.getMainLooper())
            .postDelayed(runner, 1200)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPager()
    }

    private fun initData() {
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (i in titleArticle.indices) {
            val data = Artikel(
                imageArticle.getResourceId(i, 0),
                titleArticle[i],
                contentArticle[i],
            )
            listArtikel.add(data)
        }
        imageArticle.recycle()
    }

    private fun initView() {
        val llDzikirDoaSholat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaSholat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        val llDzikirSetiapSaat: LinearLayout = findViewById(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

        val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }

        val llDzikirPagiPetang: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }

        vpArtikel = findViewById(R.id.vp_article)
        val mAdapter = ArtikelAdapter()
        mAdapter.setData(listArtikel)
        vpArtikel.adapter = mAdapter

        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        mAdapter.setOnItemClickCallback(object : OnItemCallback {
            override fun onItemClicked(item: Artikel) {
                val intent = Intent(this@MainActivity, DetailArticleActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
    }

    private fun setupViewPager() {
        val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            param.setMargins(9, 0, 8, 0)
            param.gravity = Gravity.CENTER_VERTICAL
            llSliderDots.addView(sliderIndicator[i], param)

            sliderIndicator[0]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_active
                )
            )
        }
    }
}