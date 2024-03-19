package org.example.KEDO.pages.main_page.actions

import org.example.core.PageEvent
import org.example.utils.test_entity.TestDocument

sealed interface MainPageEventKEDO: PageEvent.KEDO {
    data class OpenNewDocument(val document : TestDocument) : MainPageEventKEDO
}


