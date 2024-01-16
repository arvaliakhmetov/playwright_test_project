package org.example.configs.entities

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val users: List<User>
)
