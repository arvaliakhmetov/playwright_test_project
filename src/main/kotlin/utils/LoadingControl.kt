package org.example.utils

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import com.microsoft.playwright.options.WaitForSelectorState
import org.example.pages.card_page.utills.CardPageXPaths

object LoadingControl {
    fun waitForPageLoading(page: Page){
        page.waitForTimeout(2000.0)
        page.locator(CardPageXPaths.SPINNER).all().forEach {
            it.waitFor(Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN))
        }
    }
}