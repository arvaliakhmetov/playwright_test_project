package org.example

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import org.example.configs.TestConfig
import org.example.core.TestActionExecutor
import org.junit.jupiter.api.*
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
open class BaseTest {
    private lateinit var context: BrowserContext
    private lateinit var page: Page
    lateinit var testActionExecutor: TestActionExecutor
    lateinit var playwright: Playwright
    lateinit var browser: Browser

    @BeforeEach
    fun createContextAndPage() {
        playwright = Playwright.create()
        //BrowserType.LaunchOptions().setHeadless(false)
        browser = playwright.chromium().launch()
        context = browser.newContext()!!
        val newpage = context.newPage()
        newpage.setDefaultTimeout(50000.0)
        page = newpage
        testActionExecutor = TestActionExecutor(page,null)
    }

    @AfterEach
    fun closeContext() {
        context.close()
        playwright.close()
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun getConfigs() {
            TestConfig.init()
        }

        @JvmStatic
        @AfterAll
        fun closeBrowser() {

        }
    }
}