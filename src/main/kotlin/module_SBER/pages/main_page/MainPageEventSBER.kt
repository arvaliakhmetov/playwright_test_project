package org.example.KEDO.pages.main_page.actions

import org.example.core.PageEvent
import org.example.utils.test_entity.TestDocument

sealed interface MainPageEventSBER: PageEvent.SBER {
    data class OpenNewDocument(val document : TestDocument) : MainPageEventSBER
}


