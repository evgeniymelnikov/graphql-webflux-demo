package com.github.evgeniymelnikov.graphqlwebfluxdemo.graphql

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import reactor.core.publisher.Mono
import java.math.BigDecimal
import kotlin.random.Random

@Configuration
class ResourceIntensiveCalculationConfig {

    @Profile("garbage")
    @Bean
    fun getMuchGarbage(): ResourceIntensiveCalculationService {
        return object : ResourceIntensiveCalculationService {
            override fun calculateFiatDepositId(): Mono<Int> {
                var count = 0
                val arr = Array(800) { count++ }
                return Mono.just(arr[Random.nextInt(799)])
            }
        }
    }

    @Profile("cpu")
    @Bean
    fun getHeavyCpuCalculation(): ResourceIntensiveCalculationService {
        return object : ResourceIntensiveCalculationService {
            override fun calculateFiatDepositId(): Mono<Int> {
                var factorial = BigDecimal.ONE
                for (i in 1..Random.nextInt(1000)) {
                    factorial = factorial.multiply(BigDecimal(i))
                }
                return Mono.just(factorial.toInt())
            }
        }
    }

}