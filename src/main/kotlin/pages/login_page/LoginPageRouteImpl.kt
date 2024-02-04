package org.example.pages.login_page

import com.microsoft.playwright.Page
import org.example.core.PageEvent
import org.example.pages.login_page.actions.LoginAction
import org.example.core.PageRoute
import org.example.data.TestState
import pages.login_page.LoginPageEvent


class LoginPageRouteImpl(
    events: Array<out PageEvent>, page: Page, state: TestState

): PageRoute(events, page, state) {
    override fun handlePageEvent(pageEvent: PageEvent, page: Page, state: TestState) {
        when (pageEvent) {
            is LoginPageEvent.Login -> LoginAction(pageEvent,state,page)
        }
    }
}













