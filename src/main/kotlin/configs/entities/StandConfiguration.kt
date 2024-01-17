package org.example.configs.entities

import kotlinx.serialization.Serializable

@Serializable
data class StandConfiguration(
    val url: String,
    val contracts: HashMap<String,ContractData>
)
