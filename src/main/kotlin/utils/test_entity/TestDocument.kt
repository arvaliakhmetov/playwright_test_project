package org.example.utils.test_entity

data class TestDocument (
    val name: String? = null,
    val documentKind: String,
    val documentType: String,
    val contrAgent: String,
    val contractNumber: String,
    val date: String
)
