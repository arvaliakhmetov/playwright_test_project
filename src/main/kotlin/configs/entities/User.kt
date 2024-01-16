package org.example.configs.entities

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val login: String,
    val password: String,
    val domain: String
)
