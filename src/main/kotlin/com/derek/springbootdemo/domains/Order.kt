package com.derek.springbootdemo.domains

data class Order(val size: Int, val way: Way)

enum class Way {
    Buy, Sell
}
