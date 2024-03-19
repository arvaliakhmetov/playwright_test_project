package org.example.utils

import com.microsoft.playwright.Page

object LoadingControl {
    fun waitForPageLoading(page: Page){
        page.waitForTimeout(2000.0)
    }
}