package com.example.bankofrussia.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofrussia.databinding.ActivityMainBinding
import io.reactivex.disposables.CompositeDisposable


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}