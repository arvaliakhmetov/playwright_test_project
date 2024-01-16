package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState
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
            pageAction.getAction(page,state)
            //state = pageAction.runAction(state = state, page = page)
            logger.info("${pageAction.javaClass.simpleName} AFTER ACTION: $state")
        }
    }

    fun executeCustomAction(pageForActions: (Page) -> Unit) = pageForActions(page)

}

