package org.example.Tests

import org.example.KEDO.pages.main_page.actions.MainPageEventKEDO
import org.example.KEDO.pages.main_page.actions.MainPageEventSBER
import org.example.KEDO.pages.main_page.actions.MainPageEventSHARED
import org.example.base.BaseTest
import org.example.configs.TestConfig
import org.example.utils.DocumentAttributeGenerator
import org.example.utils.test_entity.TestDocument
import org.junit.jupiter.api.Test


class FirstTestSuit: BaseTest() {
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
            KEDO.mainPageEventRouterKEDO(MainPageEventKEDO.OpenNewDocument(document = testDocument))
            SBER.mainPageEventRouterSBER(MainPageEventSBER.OpenNewDocument(document = testDocument))
            SHARED.mainPageEventRouterSHARED(MainPageEventSHARED.OpenNewDocument(document = testDocument))
        }

    }
}