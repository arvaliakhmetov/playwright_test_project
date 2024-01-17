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

    override fun runAction(testState: TestState?, page: Page) {
        Allure.step() {
            it.name(data.javaClass.simpleName)

            val json =  Json {prettyPrint = true}
            Allure.addAttachment("STATE",json.encodeToString(testState))
            page.apply {
                testState?.testDocuments?.remove(data.testDocument)
            }
            ScreenShotUtil.saveScreenShot("screen",page)
        }
    }
}