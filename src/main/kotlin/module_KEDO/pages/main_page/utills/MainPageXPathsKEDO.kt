package org.example.pages.login_page.configs



object MainPageXPathsKEDO {
    const val BUTTON_IN_TOOLBAR = "//span[@title='%1%']"
    const val DOC_CREATION_INPUT = "(//div[contains(text(),'%1%')])[last()]/following-sibling::div//input[@class[contains(.,'dijitReset dijitInputInner')]]"
    const val BUTTON_IN_WINDOW = "(((//div[@class[contains(.,'dijitDialog')] and not(@style[contains(.,'display: none;')]) and descendant::span[contains(text(),'%1%')]])))//span[contains(text(),'%2%') and not(contains(text(),'подпис')) and contains(@class,'Button')]"
}

