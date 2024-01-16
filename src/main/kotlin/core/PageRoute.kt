package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState

interface PageRoute {
    fun getAction(page: Page, state: TestState?)
}