package org.example.Tests

import org.example.BaseTest
import org.example.configs.TestConfig
import org.example.pages.login_page.LoginPage
import org.example.pages.main_page.MainPage
import org.example.pages.util_page.UtilPage
import org.example.utils.test_entity.TestDocument
import org.junit.jupiter.api.Test
import pages.login_page.LoginPageAction
import org.example.pages.main_page.MainPageAction
import org.example.pages.util_page.UtilPageAction


class FirstTestSuit: BaseTest() {


    @Test
    fun dummyTest1(){
        val user = TestConfig.getUser("Зельцер")
        val testDocument = TestDocument(
            "asd",
            "Детализация",
            "Неформализованный",
            "",
            "",
            "")

        testActionExecutor.executeAction(
            UtilPage(UtilPageAction.Navigate(TestConfig.standConfigs.url)),
            LoginPage(LoginPageAction.Login(user)),
            MainPage(MainPageAction.CreateDocument(testDocument))
        )
        testActionExecutor.executeCustomAction { page ->
            page.click("//some[@id='uuid']")
        }
    }
}