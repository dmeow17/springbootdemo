package com.derek.springbootdemo.interfaces

import com.derek.springbootdemo.domains.MarketService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/market")
class MarketController(private val marketService: MarketService) {
    @GetMapping("/price")
    fun getLastPrice() = marketService.getLastPrice()
}