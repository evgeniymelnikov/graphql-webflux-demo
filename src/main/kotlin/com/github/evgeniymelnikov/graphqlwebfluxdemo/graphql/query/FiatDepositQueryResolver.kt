package com.github.evgeniymelnikov.graphqlwebfluxdemo.graphql.query

import com.github.evgeniymelnikov.graphqlwebfluxdemo.graphql.ResourceIntensiveCalculationService
import com.github.evgeniymelnikov.graphqlwebfluxdemo.graphql.getHeader
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FiatDepositQueryResolver(
    private val resourceIntensiveCalculationService: ResourceIntensiveCalculationService
) : GraphQLQueryResolver {
    private val headerName = "Custom-header"

    fun findFiatDepositByRequestId(requestId: String, env: DataFetchingEnvironment): Mono<FiatDeposit> {
        return Mono.defer { resourceIntensiveCalculationService.calculateFiatDepositId() }
            .map { FiatDeposit(it.toInt(), requestId, env.getHeader(headerName)) }
    }
}