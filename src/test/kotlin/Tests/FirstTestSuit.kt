package org.example.Tests

import org.example.BaseTest
import org.example.configs.TestConfig
import org.example.pages.card_page.CardPage
import org.example.pages.card_page.CardPageAction
import org.example.pages.login_page.LoginPage
import org.example.pages.main_page.MainPage
import org.example.pages.util_page.UtilPage
import org.example.utils.test_entity.TestDocument
import org.junit.jupiter.api.Test
import pages.login_page.LoginPageAction
import org.example.pages.main_page.MainPageAction
import org.example.pages.util_page.UtilPageAction
import org.example.utils.DocumentAttributeGenerator


class FirstTestSuit: BaseTest() {


    @Test
    fun dummyTest0(){
        val user = TestConfig.getUser("Зельцер")
        val contract = TestConfig.standConfigs.contracts["ost1_ost2"]!!
        val testDocument = TestDocument(
            autoTestNumber = 1,
            name = DocumentAttributeGenerator.generateDocumentName(),
            documentKind = "Детализация",
            documentType = "Неформализованный",
            contrAgent = contract.name,
            contractNumber = contract.contract,
            date = DocumentAttributeGenerator.getCurrentDate("dd.MM.yyyy")
        )

        testActionExecutor.executeAction(
            UtilPage(UtilPageAction.Navigate(TestConfig.standConfigs.url)),
            LoginPage(LoginPageAction.Login(user)),
            MainPage(MainPageAction.OpenNewDocument(testDocument)),
            CardPage(CardPageAction.FillNewDocument(testDocument, save = true, close = false)),
            CardPage(CardPageAction.DeleteDocument(testDocument))
        )
    }
    @Test
    fun dummyTest1(){
        val user = TestConfig.getUser("Зельцер")
        val contract = TestConfig.standConfigs.contracts["ost1_ost2"]!!
        val testDocument = TestDocument(
            autoTestNumber = 1,
            name = DocumentAttributeGenerator.generateDocumentName(),
            documentKind = "Детализация",
            documentType = "Неформализованный",
            contrAgent = contract.name,
            contractNumber = contract.contract,
            date = DocumentAttributeGenerator.getCurrentDate("dd.MM.yyyy")
        )

        testActionExecutor.executeAction(
            UtilPage(UtilPageAction.Navigate(TestConfig.standConfigs.url)),
            LoginPage(LoginPageAction.Login(user)),
            MainPage(MainPageAction.OpenNewDocument(testDocument)),
            CardPage(CardPageAction.FillNewDocument(testDocument, save = true, close = false)),
            CardPage(CardPageAction.DeleteDocument(testDocument))
        )
    }
    @Test
    fun dummyTest2(){
        val user = TestConfig.getUser("Зельцер")
        val contract = TestConfig.standConfigs.contracts["ost1_ost2"]!!
        val testDocument = TestDocument(
            autoTestNumber = 1,
            name = DocumentAttributeGenerator.generateDocumentName(),
            documentKind = "Детализация",
            documentType = "Неформализованный",
            contrAgent = contract.name,
            contractNumber = contract.contract,
            date = DocumentAttributeGenerator.getCurrentDate("dd.MM.yyyy")
        )

        testActionExecutor.executeAction(
            UtilPage(UtilPageAction.Navigate(TestConfig.standConfigs.url)),
            LoginPage(LoginPageAction.Login(user)),
            MainPage(MainPageAction.OpenNewDocument(testDocument)),
            CardPage(CardPageAction.FillNewDocument(testDocument, save = true, close = false)),
            CardPage(CardPageAction.DeleteDocument(testDocument))
        )
    }
}