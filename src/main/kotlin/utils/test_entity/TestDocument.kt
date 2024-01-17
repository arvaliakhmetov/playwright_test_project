package org.example.utils.test_entity

import kotlinx.serialization.Serializable

@Serializable
data class TestDocument (
    val autoTestNumber: Int,
    val name: String,
    val documentKind: String,
    val documentType: String,
    val contrAgent: String,
    val contractNumber: String,
    val date: String
)
