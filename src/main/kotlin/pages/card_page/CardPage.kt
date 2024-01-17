package org.example.pages.card_page

import com.microsoft.playwright.Page
import org.example.core.Action
import org.example.core.PageRoute
import org.example.data.TestState
import org.example.pages.card_page.actions.DeleteDocumentAction
import org.example.pages.card_page.actions.FillNewDocumentAction

class CardPage (
    val action: CardPageAction
): PageRoute {
    override fun getAction(page: Page, state: TestState?) {
        val executableAction: Action = when (action) {
            is CardPageAction.FillNewDocument -> FillNewDocumentAction(action)
            is CardPageAction.DeleteDocument -> DeleteDocumentAction(action)
        }
        executableAction.runAction(state,page)
    }
}