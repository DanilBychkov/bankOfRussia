package com.example.bankofrussia.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankofrussia.R
import com.example.bankofrussia.domain.entities.Currency
import com.example.bankofrussia.domain.entities.TypeCurrency
import com.example.bankofrussia.domain.entities.TypeCurrency.*

class CurrenciesRecyclerViewAdapter() :
    RecyclerView.Adapter<CurrenciesRecyclerViewAdapter.ItemHolder>() {

    lateinit var currencies: List<Currency>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val layout = if (viewType == INCREASE.value)
            R.layout.item_currency_increase
        else
            R.layout.item_currency_decrease

        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    override fun getItemViewType(position: Int): Int {
        return currencies[position].typeCurrency.value
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val currency = currencies[position]
        with(currency) {
            holder.data.text = data
            holder.value.text = value.toString()
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var data: TextView = itemView.findViewById(R.id.dataTextView)
        var value: TextView = itemView.findViewById(R.id.currencyTextView)
    }


}