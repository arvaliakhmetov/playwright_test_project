package org.example.pages.card_page.utills



object CardPageXPaths {
    val SPINNER = "//img[@src='/UZDO/webjars/dojox/widget/Standby/images/loading.gif']"
    val TOOLBAR_BUTTON = "//div[@role='tabpanel' and contains(@class,'dijitVisible') and contains(@aria-labelledby,'Card') or contains(@id,'DocumentResolver')]//div[@role='toolbar' and not(contains(@style,'display: none;'))]//span[@aria-disabled='false']//span[@class[contains(.,'Button')] and text()='%1%']"
    val DROPDOWN_ITEM = "//div[contains(@class,'dijitReset dijitMenuItem')]//span[.='%1%']"
    val FIELD = "(//div[@title='%1%'])[last()]//div[@class[contains(.,'Input')]]/input[1]"
    val LOAD_FILE = "//span[contains(text(),'Добавить')]/preceding::input[@type='file' and not(contains(@style,' display: none;'))]"
    val TAB = "(//div[@role='tabpanel' and contains(@class,'dijitVisible') and contains(@aria-labelledby,'Card') or contains(@id,'DocumentResolver')]//span[@class[contains(.,'tabLabel')] and text()='%1%'])[last()]"
}
