package org.example.pages.login_page

import com.microsoft.playwright.Page
import org.example.data.TestState
import org.example.core.Action
import org.example.pages.login_page.actions.LoginAction
import org.example.core.PageRoute
import pages.login_page.LoginPageAction


class LoginPage(
    val action: LoginPageAction
): PageRoute {

    override fun getAction(page: Page, state: TestState?) {
        val executableAction: Action = when (action) {
            is LoginPageAction.Login -> LoginAction(action)
        }
        executableAction.runAction(state,page)
    }
}













