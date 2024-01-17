package org.example.pages.card_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import org.example.core.Action
import org.example.data.TestState
import org.example.pages.card_page.CardPageAction

class DeleteDocumentAction(
    val data: CardPageAction.DeleteDocument
) : Action {
    override fun runAction(testState: TestState?, page: Page) {
        Allure.step() {
            it.name(data.javaClass.simpleName)
            page.apply {
                testState?.testDocuments?.remove(data.testDocument)
            }
        }
    }
}