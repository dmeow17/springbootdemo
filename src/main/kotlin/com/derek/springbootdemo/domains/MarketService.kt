package com.derek.springbootdemo.domains

import org.springframework.stereotype.Service

@Service
class MarketService {
    fun getLastPrice() = (50_000..60_000).shuffled().last() / 100.0
}