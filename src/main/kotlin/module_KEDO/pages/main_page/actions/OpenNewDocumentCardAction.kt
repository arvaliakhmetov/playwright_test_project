package org.example.KEDO.pages.main_page.actions

import com.microsoft.playwright.Page
import org.example.core.Action
import org.example.core.Action.XpathUtil.configuredPath
import org.example.core.allure.createAllureStep
import org.example.data.TestState
import org.example.pages.login_page.configs.MainPageXPathsSHARED
import org.example.utils.test_entity.TestDocument


class OpenNewDocumentActionKEDO(val document: TestDocument): Action {
    override fun run(page: Page, state: TestState) {
        page.createAllureStep("Создание нового документа"){
            click(
                configuredPath(MainPageXPathsSHARED.BUTTON_IN_TOOLBAR, "Создать проект ЭД")
            )
            fill(
                configuredPath(MainPageXPathsSHARED.DOC_CREATION_INPUT, "Тип документа"),
                document.documentType
            )
            fill(
                configuredPath(MainPageXPathsSHARED.DOC_CREATION_INPUT, "Вид документа"),
                document.documentKind
            )
            click(
                configuredPath(MainPageXPathsSHARED.BUTTON_IN_WINDOW, "Выбор вида документа для создания", "Выбрать")
            )
            state.documentName = document.name
        }
    }
}