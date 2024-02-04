package org.example.pages.card_page.actions

import com.microsoft.playwright.Page
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.core.Action
import org.example.core.PageEvent
import org.example.core.allure.addAllureAttachment
import org.example.core.allure.createAllureStep
import org.example.core.allure.takeAllureScreenShot
import org.example.data.TestState
import org.example.pages.card_page.CardPageEvent

class DeleteDocumentAction(
    data: CardPageEvent.DeleteDocument,
    testState: TestState,
    page: Page
) : Action(data, testState, page) {


    override fun runAction(data: PageEvent, testState: TestState, page: Page) {
        data as CardPageEvent.DeleteDocument
        page.createAllureStep("Удаление документа") {
            addAllureAttachment("STATE", json.encodeToString(testState).byteInputStream(Charsets.UTF_8))
            testState.testDocuments.remove(data.testDocument)
            takeAllureScreenShot()
        }
    }
}
