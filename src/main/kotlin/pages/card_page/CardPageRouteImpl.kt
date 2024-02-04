package org.example.pages.card_page

import com.microsoft.playwright.Page
import org.example.core.PageEvent
import org.example.core.PageRoute
import org.example.data.TestState
import org.example.pages.card_page.actions.DeleteDocumentAction
import org.example.pages.card_page.actions.FillNewDocumentAction

class CardPageRouteImpl (
    events: Array<out PageEvent>,
    page: Page,
    state: TestState
): PageRoute(events, page, state) {

    override fun handlePageEvent(pageEvent: PageEvent, page: Page, state: TestState) {
        when (pageEvent) {
            is CardPageEvent.FillNewDocument -> FillNewDocumentAction(pageEvent,state,page)
            is CardPageEvent.DeleteDocument -> DeleteDocumentAction(pageEvent,state,page)
        }
    }
}