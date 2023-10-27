package com.idn.doadandzikir.Utils

import com.idn.doadandzikir.Model.Artikel

interface OnItemCallback {
    fun onItemClicked(item: Artikel)
}