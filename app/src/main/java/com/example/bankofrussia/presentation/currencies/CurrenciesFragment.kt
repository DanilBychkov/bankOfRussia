package com.example.bankofrussia.presentation.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankofrussia.databinding.FragmentFirstBinding
import com.example.bankofrussia.domain.entities.Currency
import com.example.bankofrussia.presentation.adapters.CurrenciesRecyclerViewAdapter


class CurrenciesFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[CurrenciesViewModel::class.java]
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (_binding == null)
            throw RuntimeException(BINDING_NULL_CURRENCIES_FRAGMENT_EXCEPTION)

        viewModel.currenciesList.observe(requireActivity()) {
            if (it.isNotEmpty())
                initializeRecyclerView(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeRecyclerView(currencies: List<Currency>) {
        val currencyAdapter = CurrenciesRecyclerViewAdapter()

        currencyAdapter.currencies = currencies
        with(binding.recyclerView) {
            adapter = currencyAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }
    }

    companion object {
        const val BINDING_NULL_CURRENCIES_FRAGMENT_EXCEPTION =
            "BINDING_NULL_CURRENCIES_FRAGMENT_EXCEPTION"
    }
}