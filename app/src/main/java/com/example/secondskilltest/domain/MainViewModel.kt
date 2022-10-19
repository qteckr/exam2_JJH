package com.example.secondskilltest.domain

import com.example.secondskilltest.data.MainRepository
import com.example.secondskilltest.data.model.Menu

class MainViewModel {
    private val repository by lazy { MainRepository() }
    private var currentMenu: Menu? = null

    fun getMenuLabel(): String {
        val menuLabel = StringBuilder()
        Menu.values().forEach {
            menuLabel.append("$it, ")
        }
        return menuLabel.toString()
    }

    fun setCurrentMenu(menu: Menu) {
        currentMenu = menu
    }

    fun getCurrentMenu() = currentMenu

    fun isPossibleToOrder(menu: Menu): Boolean {
        val stock = repository.fetchStock()
        val cost = repository.fetchCost(menu.name)
        return stock.bean >= cost!!.bean && stock.water >= cost.water && stock.milk >= cost.milk
    }

    fun sellCoffee(menu: Menu) {
        val stock = repository.fetchStock()
        val cost = repository.fetchCost(menu.name)
        val sales = repository.fetchSales()
        stock.bean -= cost!!.bean
        stock.water -= cost.water
        stock.milk -= cost.milk
        sales.profit += cost.price
        sales.history.push(menu.name)
    }

    fun getStockReport() = repository.composeStockReport()

    fun getSalesReport() = repository.composeSalesReport()
}