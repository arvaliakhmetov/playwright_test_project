package org.example.pages.card_page

import org.example.core.PageEvent
import org.example.utils.test_entity.TestDocument

sealed interface CardPageEvent: PageEvent {
    data class FillNewDocument(val testDocument: TestDocument, val save: Boolean,val close: Boolean): CardPageEvent
    data class DeleteDocument(val testDocument: TestDocument): CardPageEvent
}