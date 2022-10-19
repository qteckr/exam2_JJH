package com.example.secondskilltest.domain

import com.example.secondskilltest.data.MainRepository
import com.example.secondskilltest.data.model.Menu

class MainViewModel {
    private val repository by lazy { MainRepository() }
    private var currentMenu: Menu? = null

    fun getMenu(): String {
        val menuLabel = StringBuilder()
        repository.fetchMenu().forEach {
            menuLabel.append("$it ")
        }
        return menuLabel.toString()
    }

    fun setCurrentMenu(menu: Menu) {
        currentMenu = menu
    }

    fun getCurrentMenu() = currentMenu

    fun isPossibleToOrder(menu: Menu): Boolean {
        val stock = repository.fetchStock()
        val cost = repository.fetchCost(menu)
        return stock.coffee >= cost["coffee"]!! && stock.water >= cost["water"]!! && stock.milk >= cost["milk"]!!
    }

    fun sellCoffee(menu: Menu) {
        val stock = repository.fetchStock()
        val cost = repository.fetchCost(menu)
        val sales = repository.fetchSales()
        stock.coffee -= cost["coffee"]!!
        stock.water -= cost["water"]!!
        stock.milk -= cost["milk"]!!
        sales.profit += cost["profit"]!!
        sales.history.push(menu.name)
    }

    fun getStockReport() = repository.composeStockReport()

    fun getSalesReport() = repository.composeSalesReport()
}