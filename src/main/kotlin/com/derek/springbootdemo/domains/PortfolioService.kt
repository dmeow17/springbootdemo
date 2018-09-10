package com.derek.springbootdemo.domains

import org.springframework.stereotype.Service

@Service
class PortfolioService(private val marketService: MarketService) {
    private val executions = mutableListOf<Execution>()

    fun getExecutions() = executions

    fun addExecution(order: Order): Execution {
        val execution = Execution(order, marketService.getLastPrice())
        executions.add(execution)
        return execution
    }
}