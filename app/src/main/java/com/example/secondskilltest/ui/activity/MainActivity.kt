package com.example.secondskilltest.ui.activity

import android.app.AlertDialog
import android.view.View
import com.example.secondskilltest.R
import com.example.secondskilltest.data.model.Menu
import com.example.secondskilltest.databinding.ActivityMainBinding
import com.example.secondskilltest.domain.MainViewModel
import com.example.secondskilltest.ui.activity.base.BaseActivity
import com.example.secondskilltest.ui.component.MainAdapter
import com.example.secondskilltest.ui.component.MenuDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val adapter by lazy { MainAdapter() }
    private val viewModel by lazy { MainViewModel() }
    override fun init() {
        super.init()
        binding.activity = this@MainActivity
        binding.adapter = adapter
    }

    private var isStockShowing = false
    private var isSalesShowing = false

    fun showMenu(view: View) {
        binding.textView.text = viewModel.getMenuLabel()
    }

    fun choiceMenu(view: View) {
        MenuDialog(
            onClickMenu = {
                viewModel.setCurrentMenu(it)
                showChosenMenu(it)
            }
        ).show(supportFragmentManager, "dialogMenu")
    }

    fun showIsPossibleToOrder(view: View) {
        val menu = viewModel.getCurrentMenu()
        if (menu == null) {
            binding.textView.text = "선택된 메뉴가 없습니다."
        } else {
            if (viewModel.isPossibleToOrder(menu)) {
                showOrderDialog(menu)
            } else {
                binding.textView.text = "주문할 수 없습니다. : 재고 부족"
            }
        }
    }

    private fun showOrderDialog(menu: Menu) {
        AlertDialog.Builder(this@MainActivity)
            .setTitle("주문이 가능합니다.")
            .setMessage("주문하시겠습니까?")
            .setPositiveButton(
                "주문하기"
            ) { dialog, _ ->
                order(menu)
                dialog.dismiss()
            }
            .setNegativeButton(
                "취소"
            ) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    fun showStockReport(view: View) {
        adapter.submitList(viewModel.getStockReport())
        isStockShowing = true
        isSalesShowing = false
    }

    fun showSalesReport(view: View) {
        adapter.submitList(viewModel.getSalesReport())
        isSalesShowing = true
        isStockShowing = false
    }

    private fun showChosenMenu(menu: Menu) {
        binding.textView.text = "선택한 메뉴 : ${menu.name}"
    }

    private fun order(menu: Menu) {
        viewModel.sellCoffee(menu)
        Snackbar.make(binding.root, "${menu.name} 메뉴를 주문했습니다.", Snackbar.LENGTH_SHORT).show()
        updateList()
    }

    private fun updateList() {
        if (isStockShowing) {
            adapter.submitList(viewModel.getStockReport())
        } else if (isSalesShowing) {
            adapter.submitList(viewModel.getSalesReport())
        }
    }
}