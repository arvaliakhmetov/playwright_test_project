package org.example.pages.main_page

import com.microsoft.playwright.Page
import org.example.data.TestState
import org.example.core.Action
import org.example.pages.main_page.actions.CreateDocumentAction
import org.example.core.PageRoute



class MainPage(
    val action: MainPageAction
): PageRoute {

    override fun getAction(page: Page, state: TestState?) {
        val executableAction: Action = when (action) {
            is MainPageAction.CreateDocument -> CreateDocumentAction(action)
        }
        executableAction.runAction(state,page)
    }
}













