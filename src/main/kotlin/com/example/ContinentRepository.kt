package com.example

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository

@Repository
interface ContinentRepository : CoroutineCrudRepository<Continent, Int>

