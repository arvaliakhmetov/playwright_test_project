package org.example.KEDO.pages.main_page

import com.microsoft.playwright.Page
import org.example.KEDO.pages.main_page.actions.MainPageEventSBER
import org.example.KEDO.pages.main_page.actions.OpenNewDocumentActionSBER
import org.example.core.Action
import org.example.core.PageRoute
import org.example.data.TestState


class MainPageEventRouterSBER (
    events: Array<out MainPageEventSBER>,
    page: Page,
    state: TestState

): PageRoute<MainPageEventSBER>(events, page, state) {

    override fun handlePageEvent(pageEvent: MainPageEventSBER, page: Page, state: TestState): Action {
        return when (pageEvent) {
            is MainPageEventSBER.OpenNewDocument -> OpenNewDocumentActionSBER(pageEvent.document)
        }
    }

}













