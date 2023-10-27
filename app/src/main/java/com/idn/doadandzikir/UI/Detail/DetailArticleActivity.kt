package com.idn.doadandzikir.UI.Detail

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {

    private var _binding: ActivityDetailArticleBinding? = null
    private val binding get() = _binding as ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Artikel Islam"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("key") as? Artikel
        }

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it) }
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