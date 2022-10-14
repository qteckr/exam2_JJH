package com.example.secondskilltest.ui.activity

import android.view.View
import com.example.secondskilltest.R
import com.example.secondskilltest.databinding.ActivityMainBinding
import com.example.secondskilltest.ui.base.BaseActivity
import com.example.secondskilltest.ui.component.MainAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val adapter by lazy { MainAdapter() }
    override fun init() {
        super.init()
        binding.activity = this@MainActivity
        binding.adapter = adapter
    }

    fun onClickMenu1(view: View) {
        adapter.submitList(listOf("1", "2"))
    }

    fun onClickMenu2(view: View) {

    }

    fun onClickMenu3(view: View) {

    }

    fun onClickMenu4(view: View) {

    }

    fun onClickMenu5(view: View) {

    }
}