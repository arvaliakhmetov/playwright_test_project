package org.example.router

import com.microsoft.playwright.Page
import org.example.KEDO.pages.RouterKEDO
import org.example.KEDO.pages.RouterSBER
import org.example.KEDO.pages.RouterSHARED
import org.example.KEDO.pages.main_page.MainPageEventRouterKEDO
import org.example.KEDO.pages.main_page.MainPageEventRouterSBER
import org.example.KEDO.pages.main_page.MainPageEventRouterSHARED
import org.example.KEDO.pages.main_page.actions.MainPageEventKEDO
import org.example.KEDO.pages.main_page.actions.MainPageEventSBER
import org.example.KEDO.pages.main_page.actions.MainPageEventSHARED
import org.example.data.TestState


class HeadRouter (
    private val page: Page,
    private val state: TestState
) {
    val KEDO: RouterKEDO = object : RouterKEDO {
        override fun mainPageEventRouterKEDO(vararg events: MainPageEventKEDO) =
            MainPageEventRouterKEDO(events, page, state)
    }

    val SBER: RouterSBER = object : RouterSBER {
        override fun mainPageEventRouterSBER(vararg events: MainPageEventSBER) =
            MainPageEventRouterSBER(events, page, state)
    }

    val SHARED: RouterSHARED = object : RouterSHARED {
        override fun mainPageEventRouterSHARED(vararg events: MainPageEventSHARED) =
            MainPageEventRouterSHARED(events, page, state)
    }
}