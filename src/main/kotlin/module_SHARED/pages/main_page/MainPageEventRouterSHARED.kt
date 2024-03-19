package org.example.KEDO.pages.main_page

import com.microsoft.playwright.Page
import org.example.KEDO.pages.main_page.actions.MainPageEventSHARED
import org.example.KEDO.pages.main_page.actions.OpenNewDocumentActionSHARED
import org.example.core.Action
import org.example.core.PageRoute
import org.example.data.TestState


class MainPageEventRouterSHARED (
    events: Array<out MainPageEventSHARED>,
    page: Page,
    state: TestState

): PageRoute<MainPageEventSHARED>(events, page, state) {

    override fun handlePageEvent(pageEvent: MainPageEventSHARED, page: Page, state: TestState): Action {
        return when (pageEvent) {
            is MainPageEventSHARED.OpenNewDocument -> OpenNewDocumentActionSHARED(pageEvent.document)
        }
    }

}













