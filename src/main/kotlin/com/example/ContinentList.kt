package com.example

import arrow.core.Either
import arrow.fx.coroutines.parMap
import io.micronaut.cache.annotation.CacheConfig
import io.micronaut.cache.annotation.Cacheable
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.toList

@Singleton
@CacheConfig("default")
class ContinentList(
    val repository: ContinentRepository,
) : ListContinentPort {
    @Cacheable(value = ["continents"], parameters = ["#query"])
    override suspend fun execute(query: ContinentQuery.All): Either<Throwable, List<ContinentDto>> = Either.catch {
        repository.findAll().toList().parMap { it.toDto() }
    }
}
