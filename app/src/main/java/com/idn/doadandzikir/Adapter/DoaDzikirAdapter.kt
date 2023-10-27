package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.DoaDzikirItem
import com.idn.doadandzikir.R

class DoaDzikirAdapter : RecyclerView.Adapter<DoaDzikirAdapter.DzikirViewHolder>() {
    private val listData = ArrayList<DoaDzikirItem>()

    fun setData(list: List<DoaDzikirItem>) {
        listData.clear()
        listData.addAll(list)
    }

    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.findViewById<TextView>(R.id.tv_desc)
        val textArabic = view.findViewById<TextView>(R.id.tv_lafaz)
        val textTranslate = view.findViewById<TextView>(R.id.tv_terjemah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent, false)
    )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        holder.apply {
            textTitle.text = listData[position].title
            textArabic.text = listData[position].arabic
            textTranslate.text = listData[position].translate
        }
    }
}