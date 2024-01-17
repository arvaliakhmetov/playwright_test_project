package org.example.pages.card_page

import org.example.core.PageAction
import org.example.utils.test_entity.TestDocument

sealed interface CardPageAction: PageAction {
    data class FillNewDocument(val testDocument: TestDocument, val save: Boolean,val close: Boolean): CardPageAction

    data class DeleteDocument(val testDocument: TestDocument): CardPageAction
}