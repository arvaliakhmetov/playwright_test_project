package org.example.pages.card_page.actions

import com.microsoft.playwright.Page

import org.example.core.Action
import org.example.core.Action.XpathUtil.configuredPath
import org.example.core.PageEvent
import org.example.core.allure.createAllureStep
import org.example.core.allure.takeAllureScreenShot
import org.example.data.TestState
import org.example.pages.card_page.CardPageEvent
import org.example.pages.card_page.utills.CardPageXPaths
import org.example.utils.LoadingControl
import java.nio.file.Paths

class FillNewDocumentAction(
    data: CardPageEvent.FillNewDocument,
    testState: TestState,
    page: Page
) : Action(data, testState, page) {

    override fun runAction(data: PageEvent, testState: TestState, page: Page) {
        data as CardPageEvent.FillNewDocument
        page.createAllureStep("Заполенение полей нового документа") {
            val fileChooser = page.waitForFileChooser {
                click(CardPageXPaths.LOAD_FILE)
            }
            fileChooser.setFiles(Paths.get("data/Default.pdf"))
            LoadingControl.waitForPageLoading(page)
            click( configuredPath(CardPageXPaths.TAB,"Атрибуты") )
            fill(
                configuredPath(CardPageXPaths.FIELD, "Номер документа"),
                data.testDocument.name
            )
            fill(
                configuredPath(CardPageXPaths.FIELD, "Дата документа"),
                data.testDocument.date
            )
            fill(
                configuredPath(CardPageXPaths.FIELD, "Контрагент"),
                data.testDocument.contrAgent
            )
            click(
                configuredPath(CardPageXPaths.DROPDOWN_ITEM, data.testDocument.contrAgent)
            )
            fill(
                configuredPath(CardPageXPaths.FIELD, "Номер договора"),
                data.testDocument.contractNumber
            )
            click(
                configuredPath(CardPageXPaths.DROPDOWN_ITEM, data.testDocument.contractNumber)
            )
            if (data.save) {
                click(
                    configuredPath(CardPageXPaths.TOOLBAR_BUTTON, "Сохранить")
                )
            }
            takeAllureScreenShot()
            testState.testDocuments.add(data.testDocument)
        }
    }
}
