package com.github.evgeniymelnikov.graphqlwebfluxdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.reactive.config.EnableWebFlux
import graphql.schema.GraphQLSchema
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import graphql.schema.GraphQLObjectType
import graphql.Scalars
import graphql.kickstart.tools.SchemaParser
import graphql.schema.GraphQLCodeRegistry
import graphql.schema.FieldCoordinates
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import graphql.schema.GraphQLFieldDefinition.Builder
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableWebFlux
class MainApplication {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MainApplication::class.java, *args)
        }
    }
}