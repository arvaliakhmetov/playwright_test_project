package org.example.pages.card_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.core.Action
import org.example.data.TestState
import org.example.pages.card_page.CardPageAction
import org.example.utils.ScreenShotUtil

class DeleteDocumentAction(
    val data: CardPageAction.DeleteDocument
) : Action {
    val json =  Json {prettyPrint = true}

    override fun runAction(testState: TestState?, page: Page) {
        Allure.step() {
            it.name(data.javaClass.simpleName)
            Allure.addAttachment("STATE",json.encodeToString(testState))
            testState?.testDocuments?.remove(data.testDocument)
            ScreenShotUtil.saveScreenShot("screen",page)
        }
    }
}