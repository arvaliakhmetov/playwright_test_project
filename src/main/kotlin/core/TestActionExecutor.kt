package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState
import org.example.utils.LoadingControl
import org.slf4j.LoggerFactory


class TestActionExecutor(
    private val page: Page,
    private var state: TestState? = null,
) {
    val logger = LoggerFactory.getLogger(TestActionExecutor::class.java)
    init {
        state = state ?: TestState()
    }


    fun executeAction(vararg pageActions: PageRoute) {
        pageActions.forEach { pageAction ->
            logger.info("${pageAction.javaClass.simpleName} BEFORE ACTION: $state")
            LoadingControl.waitForPageLoading(page)
            pageAction.getAction(page,state)
            LoadingControl.waitForPageLoading(page)
            //state = pageAction.runAction(state = state, page = page)
            logger.info("${pageAction.javaClass.simpleName} AFTER ACTION: $state")
        }
    }

    fun executeCustomAction(pageForActions: (Page) -> Unit) = pageForActions(page)

}

