package org.example.pages.card_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure.step

import org.example.core.Action
import org.example.core.XpathUtil.configuredPath
import org.example.data.TestState
import org.example.pages.card_page.CardPageAction
import org.example.pages.card_page.utills.CardPageXPaths
import org.example.utils.LoadingControl
import java.nio.file.Paths

class FillNewDocumentAction(
    val data: CardPageAction.FillNewDocument
) : Action {
    override fun runAction(testState: TestState?, page: Page) {
        step() {
            it.name(data.javaClass.simpleName)
            page.apply {
                val fileChooser = page.waitForFileChooser {
                    click(CardPageXPaths.LOAD_FILE)
                }
                fileChooser.setFiles(Paths.get("data/Default.pdf"))
                LoadingControl.waitForPageLoading(page)
                click(
                    configuredPath(CardPageXPaths.TAB, "Атрибуты")
                )
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
                testState?.testDocuments?.add(data.testDocument)
            }
        }
    }
}