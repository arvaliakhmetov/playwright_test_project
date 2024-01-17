package org.example.pages.main_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import org.example.core.Action
import org.example.core.XpathUtil.configuredPath
import org.example.data.TestState
import org.example.pages.login_page.configs.MainPageXPaths
import org.example.pages.main_page.MainPageAction


class OpenNewDocumentCardAction(
    private val data: MainPageAction.OpenNewDocument,
) : Action {
    override fun runAction(testState: TestState?, page: Page) {
        Allure.step() {
            it.name(data.javaClass.simpleName)
            page.apply {
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
            }
        }
    }
}

