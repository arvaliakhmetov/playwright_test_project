package org.example.pages.util_page

import com.microsoft.playwright.Page
import org.example.core.PageEvent
import org.example.core.PageRoute
import org.example.data.TestState
import org.example.pages.util_page.actions.NavigateAction


class UtilPageRouteImpl(
    events: Array<out PageEvent>,
    page: Page,
    state: TestState
): PageRoute (events, page, state) {
    override fun handlePageEvent(pageEvent: PageEvent, page: Page, state: TestState) {
        when (pageEvent) {
            is UtilPageEvent.Navigate -> NavigateAction(pageEvent,state,page)
        }
    }
}













