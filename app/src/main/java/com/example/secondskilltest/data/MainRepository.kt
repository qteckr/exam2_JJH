package com.example.secondskilltest.data

import com.example.secondskilltest.data.model.Menu
import com.example.secondskilltest.data.model.ReportItem
import com.example.secondskilltest.data.model.Sales
import com.example.secondskilltest.data.model.Stock
import java.util.*

class MainRepository {
    private val stock = Stock(coffee = 10000, water = 10000, milk = 5000)
    private val sales = Sales(profit = 0, history = LinkedList())
    private val menu = ArrayList<Menu>()

    init {
        Menu.values().forEach {
            menu.add(it)
        }
    }

    fun fetchMenu() = menu

    fun fetchCost(menu: Menu): HashMap<String, Int> {
        val hashMap = HashMap<String, Int>()
        when (menu) {
            Menu.ESPRESSO -> {
                hashMap["coffee"] = 100
                hashMap["water"] = 30
                hashMap["milk"] = 0
                hashMap["profit"] = 4000
            }
            Menu.LATTE -> {
                hashMap["coffee"] = 100
                hashMap["water"] = 70
                hashMap["milk"] = 30
                hashMap["profit"] = 5000
            }
            Menu.AMERICANO -> {
                hashMap["coffee"] = 100
                hashMap["water"] = 100
                hashMap["milk"] = 0
                hashMap["profit"] = 4500
            }
        }
        return hashMap
    }

    fun fetchStock() = stock

    fun fetchSales() = sales

    fun composeStockReport() = listOf(
        ReportItem("커피", stock.coffee),
        ReportItem("물", stock.water),
        ReportItem("우유", stock.milk)
    )

    fun composeSalesReport(): List<ReportItem> {
        var espressoSales = 0
        var latteSales = 0
        var americanoSales = 0
        sales.history.forEach {
            when (it) {
                "ESPRESSO" -> {
                    espressoSales++
                }
                "LATTE" -> {
                    latteSales++
                }
                "AMERICANO" -> {
                    americanoSales++
                }
            }
        }
        return listOf(
            ReportItem("매출", sales.profit),
            ReportItem("에스프레소 판매량", espressoSales),
            ReportItem("라떼 판매량", latteSales),
            ReportItem("아메리카노 판매량", americanoSales)
        )
    }
}