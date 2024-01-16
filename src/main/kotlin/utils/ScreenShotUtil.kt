package org.example.utils

import com.microsoft.playwright.Page
import com.microsoft.playwright.options.LoadState
import io.qameta.allure.Allure
import io.qameta.allure.Step
import java.io.ByteArrayInputStream


object ScreenShotUtil {
    @Step
    fun saveScreenShot(fileName: String?,page:Page) {
        page.waitForLoadState(LoadState.NETWORKIDLE)
        Allure.addAttachment(fileName,ByteArrayInputStream(page.screenshot(Page.ScreenshotOptions().setFullPage(true))))
    }
}