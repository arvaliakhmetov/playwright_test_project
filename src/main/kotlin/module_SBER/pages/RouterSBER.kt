package org.example.KEDO.pages

import org.example.KEDO.pages.main_page.actions.MainPageEventSBER
import org.example.core.PageRoute


interface RouterSBER {
    fun mainPageEventRouterSBER(vararg events: MainPageEventSBER): PageRoute<MainPageEventSBER>
}
