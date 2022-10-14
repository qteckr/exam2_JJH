package com.example.secondskilltest.ui

import android.view.View
import com.example.secondskilltest.R
import com.example.secondskilltest.databinding.ActivityMainBinding
import com.example.secondskilltest.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun init() {
        super.init()
        binding.activity = this@MainActivity
    }

    fun onClickMenu1(view: View) {

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