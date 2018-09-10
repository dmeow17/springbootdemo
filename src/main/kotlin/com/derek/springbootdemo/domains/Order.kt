package com.derek.springbootdemo.domains

data class Order(val size: Int, val way: Way, val product: String?) {
    enum class Way {
        Buy, Sell
    }
}
