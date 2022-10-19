package com.example.secondskilltest.ui.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        startProcess()
    }

    protected open fun synchronizeDataBinding() {

    }

    protected open fun init() {
        initViewDataBinding()
    }

    protected open fun startProcess() {

    }

    private fun initViewDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}