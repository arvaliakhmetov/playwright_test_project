package org.example.pages.main_page

import org.example.utils.test_entity.TestDocument
import org.example.core.PageEvent

sealed interface MainPageEvent: PageEvent {

    /**
     * Событие открывания карточки нового документа
     */
    data class OpenNewDocument(val document: TestDocument): MainPageEvent

}