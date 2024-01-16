package org.example.pages.main_page

import org.example.utils.test_entity.TestDocument
import org.example.core.PageAction

sealed interface MainPageAction: PageAction {

    data class CreateDocument(val document: TestDocument): MainPageAction

}