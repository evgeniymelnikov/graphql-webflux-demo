package com.github.evgeniymelnikov.graphqlwebfluxdemo.graphql

import graphql.kickstart.spring.GraphQLSpringContext
import graphql.schema.DataFetchingEnvironment

fun DataFetchingEnvironment.getHeader(header: String): String? =
    (getContext() as GraphQLSpringContext).serverWebExchange.request.headers.getFirst(header)