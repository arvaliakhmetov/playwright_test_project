package org.example.KEDO.pages

import org.example.KEDO.pages.main_page.actions.MainPageEventSHARED
import org.example.core.PageRoute


interface RouterSHARED {
    fun mainPageEventRouterSHARED(vararg events: MainPageEventSHARED): PageRoute<MainPageEventSHARED>
}
