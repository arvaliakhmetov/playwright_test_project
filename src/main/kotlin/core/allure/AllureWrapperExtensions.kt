package org.example.core.allure

import com.microsoft.playwright.Page
import com.microsoft.playwright.options.LoadState
import io.qameta.allure.Allure
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.Instant

/**
 * extension function для Page,
 * создает шаг в Allure отчете
 * @param name имя шага
 * @param block runnable
 */
fun Page.createAllureStep(name: String,block: Page.() -> Unit) {
    Allure.step {
        it.name(name)
        this.apply {
            block.invoke(this)
        }
    }
}

fun Page.addAllureAttachment(name: String,inputStream: InputStream){
    Allure.addAttachment(name, inputStream)
}

fun Page.takeAllureScreenShot(fileName: String? = "screen_shot_${Instant.now().epochSecond}"){
    this.waitForLoadState(LoadState.NETWORKIDLE)
    Allure.addAttachment(fileName, ByteArrayInputStream(this.screenshot(Page.ScreenshotOptions().setFullPage(true))))
}


