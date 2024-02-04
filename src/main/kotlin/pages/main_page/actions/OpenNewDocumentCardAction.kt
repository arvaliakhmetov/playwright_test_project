package org.example.pages.main_page.actions

import com.microsoft.playwright.Page
import org.example.core.Action
import org.example.core.Action.XpathUtil.configuredPath
import org.example.core.PageEvent
import org.example.core.allure.createAllureStep
import org.example.data.TestState
import org.example.pages.login_page.configs.MainPageXPaths
import org.example.pages.main_page.MainPageEvent


class OpenNewDocumentCardAction(
    data: MainPageEvent.OpenNewDocument,
    testState: TestState,
    page: Page
) : Action(data, testState, page) {

    override fun runAction(data: PageEvent, testState: TestState, page: Page) {
        data as MainPageEvent.OpenNewDocument
        page.createAllureStep("Создание нового документа"){
            click(
                configuredPath(MainPageXPaths.BUTTON_IN_TOOLBAR, "Создать проект ЭД")
            )
            fill(
                configuredPath(MainPageXPaths.DOC_CREATION_INPUT, "Тип документа"),
                data.document.documentType
            )
            fill(
                configuredPath(MainPageXPaths.DOC_CREATION_INPUT, "Вид документа"),
                data.document.documentKind
            )
            click(
                configuredPath(MainPageXPaths.BUTTON_IN_WINDOW, "Выбор вида документа для создания", "Выбрать")
            )
            testState.documentName = data.document.name
        }
    }
}

