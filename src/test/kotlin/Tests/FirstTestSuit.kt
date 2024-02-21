package org.example.Tests

import org.example.base.BaseTest
import org.example.configs.TestConfig
import org.example.pages.card_page.CardPageEvent
import org.example.utils.test_entity.TestDocument
import org.junit.jupiter.api.Test
import pages.login_page.LoginPageEvent
import org.example.pages.main_page.MainPageEvent
import org.example.pages.util_page.*
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

        testActionExecutor.executeAction {
            utilPageEventRouter(UtilPageEvent.Navigate(TestConfig.standConfigs.url))
            loginPageEventRouter(LoginPageEvent.Login(user))
            mainPageEventRouter(MainPageEvent.OpenNewDocument(testDocument))
            cardPageEventRouter(
                CardPageEvent.FillNewDocument(testDocument, save = true, close = false),
                CardPageEvent.DeleteDocument(testDocument)
            )
        }
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

        testActionExecutor.executeAction {
            utilPageEventRouter(UtilPageEvent.Navigate(TestConfig.standConfigs.url))
            loginPageEventRouter(LoginPageEvent.Login(user))
            mainPageEventRouter(MainPageEvent.OpenNewDocument(testDocument))
            cardPageEventRouter(
                CardPageEvent.FillNewDocument(testDocument, save = true, close = false),
                CardPageEvent.DeleteDocument(testDocument)
            )
        }
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

        testActionExecutor.executeAction {
            utilPageEventRouter(UtilPageEvent.Navigate(TestConfig.standConfigs.url))
            loginPageEventRouter(LoginPageEvent.Login(user))
            mainPageEventRouter(MainPageEvent.OpenNewDocument(testDocument))
            cardPageEventRouter(
                CardPageEvent.FillNewDocument(testDocument, save = true, close = false),
                CardPageEvent.DeleteDocument(testDocument)
            )
        }
    }
}