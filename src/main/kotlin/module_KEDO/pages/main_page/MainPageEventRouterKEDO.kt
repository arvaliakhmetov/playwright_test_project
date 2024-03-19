package org.example.KEDO.pages.main_page

import com.microsoft.playwright.Page
import org.example.KEDO.pages.main_page.actions.MainPageEventKEDO
import org.example.KEDO.pages.main_page.actions.OpenNewDocumentActionKEDO
import org.example.core.Action
import org.example.core.PageRoute
import org.example.data.TestState


class MainPageEventRouterKEDO (
    events: Array<out MainPageEventKEDO>,
    page: Page,
    state: TestState

): PageRoute<MainPageEventKEDO>(events, page, state) {

    override fun handlePageEvent(pageEvent: MainPageEventKEDO, page: Page, state: TestState): Action {
        return when (pageEvent) {
            is MainPageEventKEDO.OpenNewDocument -> OpenNewDocumentActionKEDO(pageEvent.document)
        }
    }

}













