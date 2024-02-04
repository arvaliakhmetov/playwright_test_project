package org.example.pages.main_page

import com.microsoft.playwright.Page
import org.example.core.PageEvent
import org.example.pages.main_page.actions.OpenNewDocumentCardAction
import org.example.core.PageRoute
import org.example.data.TestState


class MainPageRouteImpl (
    events: Array<out PageEvent>,
    page: Page,
    state: TestState

): PageRoute(events, page, state) {
    override fun handlePageEvent(pageEvent: PageEvent, page: Page, state: TestState) {
        when (pageEvent) {
            is MainPageEvent.OpenNewDocument -> OpenNewDocumentCardAction(pageEvent,state,page)
        }
    }

}













