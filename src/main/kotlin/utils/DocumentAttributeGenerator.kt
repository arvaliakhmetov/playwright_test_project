package org.example.utils

import java.text.SimpleDateFormat
import java.util.*

object DocumentAttributeGenerator {
    fun generateDocumentName(): String{
        return "Auto_${(UUID.randomUUID()).toString().substring(0, 8)}"
    }

    fun getCurrentDate(format: String): String{
        val f = SimpleDateFormat(format)
        return f.format(Date())
    }
}