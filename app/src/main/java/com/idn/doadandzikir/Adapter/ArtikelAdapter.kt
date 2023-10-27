package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.Utils.OnItemCallback
import com.idn.doadandzikir.databinding.ItemArtikelBinding

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArticleViewHolder>() {

    private var listArtikel = ArrayList<Artikel>()
    private var onItemCallback: OnItemCallback? = null

    fun setData(list: List<Artikel>) {
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }

    inner class ArticleViewHolder(val view: ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder(
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listArtikel.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            onItemCallback?.onItemClicked(data)
        }
    }
}