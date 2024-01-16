package org.example.data

import org.example.utils.test_entity.TestDocument

data class TestState(
    val documentName: String? = "",
    val docStatus: String = "",
    val someState: String = "",
    var testDocuments: MutableList<TestDocument> = mutableListOf()
)
