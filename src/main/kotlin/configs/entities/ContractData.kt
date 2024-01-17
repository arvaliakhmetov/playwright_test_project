package org.example.configs.entities

import kotlinx.serialization.Serializable

@Serializable
data class ContractData(
    val name: String,
    val id: String,
    val contract: String,
    val contract_code: String,
    val date: String
)
