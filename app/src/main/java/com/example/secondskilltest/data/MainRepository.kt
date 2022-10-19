package com.example.secondskilltest.data

import com.example.secondskilltest.data.model.Coffee
import com.example.secondskilltest.data.model.ReportItem
import com.example.secondskilltest.data.model.Sales
import com.example.secondskilltest.data.model.Stock
import java.util.*

class MainRepository {
    private val stock = Stock(bean = 10000, water = 10000, milk = 5000)
    private val sales = Sales(profit = 0, history = LinkedList())
    private val cost = HashMap<String, Coffee>()
    init {
        cost["ESPRESSO"] = Coffee(100, 30, 0, 4000)
        cost["LATTE"] = Coffee(100, 70, 30, 5000)
        cost["AMERICANO"] = Coffee(100, 100, 0, 4500)
    }

    fun fetchCost(name: String) = cost[name]

    fun fetchStock() = stock

    fun fetchSales() = sales

    fun composeStockReport() = listOf(
        ReportItem("커피", stock.bean),
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