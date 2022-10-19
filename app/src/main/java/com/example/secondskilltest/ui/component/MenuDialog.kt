package com.example.secondskilltest.ui.component

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.secondskilltest.R
import com.example.secondskilltest.data.model.Menu
import com.example.secondskilltest.databinding.DialogMenuBinding

class MenuDialog(
    private val onClickMenu: (Menu) -> Unit
) :
    DialogFragment() {
    private lateinit var binding: DialogMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_menu, container, false)
        isCancelable = true
        binding.root.background = ColorDrawable(Color.TRANSPARENT)
        initView()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setBackgroundTransparent()
    }

    private fun setBackgroundTransparent() {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun initView() {
        with(binding) {
            btnEspresso.setOnClickListener {
                onClickMenu(Menu.ESPRESSO)
                dismiss()
            }
            btnLatte.setOnClickListener {
                onClickMenu(Menu.LATTE)
                dismiss()
            }
            btnAmericano.setOnClickListener {
                onClickMenu(Menu.AMERICANO)
                dismiss()
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }
}