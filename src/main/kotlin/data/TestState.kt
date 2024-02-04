package org.example.data

import kotlinx.serialization.Serializable
import org.example.utils.test_entity.TestDocument

@Serializable
data class TestState(
    var documentName: String? = "",
    val docStatus: String = "",
    val someState: String = "",
    var testDocuments: MutableList<TestDocument> = mutableListOf()
)
