package org.example.pages.main_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Step
import org.example.core.Action
import org.example.core.XpathUtil.configuredPath
import org.example.data.TestState
import org.example.pages.login_page.configs.MainPageXPaths
import org.example.pages.main_page.MainPageAction


class CreateDocumentAction(
    private val documentData: MainPageAction.CreateDocument,
) : Action {

    @Step("Создание документа")
    override fun runAction(testState: TestState?, page: Page){
        page.apply {
            click(
                configuredPath(MainPageXPaths.BUTTON_IN_TOOLBAR,"Создать проект ЭД")
            )
            fill(
                configuredPath(MainPageXPaths.DOC_CREATION_INPUT,"Тип документа"),
                documentData.document.documentType
            )
            fill(
                configuredPath(MainPageXPaths.DOC_CREATION_INPUT,"Вид документа"),
                documentData.document.documentKind
            )
            click(
                configuredPath(MainPageXPaths.BUTTON_IN_WINDOW,"Выбор вида документа для создания","Выбрать")
            )
            waitForTimeout(30000.0)
        }
        testState?.testDocuments?.add(documentData.document)
    }
}

