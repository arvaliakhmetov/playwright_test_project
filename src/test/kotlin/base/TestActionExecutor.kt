package base

import com.microsoft.playwright.Page
import org.example.data.TestState
import org.example.router.HeadRouter
import org.slf4j.LoggerFactory


class TestActionExecutor(
    private val page: Page,
    private var state: TestState,
) {
    val logger = LoggerFactory.getLogger(TestActionExecutor::class.java)


    private val router = HeadRouter(page,state)
    fun executeAction(pageActions: HeadRouter.() -> Unit)= pageActions(router)

    fun executeCustomAction(pageForActions: (Page) -> Unit) = pageForActions(page)

}

