package com.github.evgeniymelnikov.graphqlwebfluxdemo.graphql

import reactor.core.publisher.Mono

interface ResourceIntensiveCalculationService {

    fun calculateFiatDepositId(): Mono<Int>
}