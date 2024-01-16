package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState

interface Action{
    fun runAction(testState: TestState?, page: Page)
}