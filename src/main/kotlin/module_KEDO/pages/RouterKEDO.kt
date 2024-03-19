package org.example.KEDO.pages

import org.example.KEDO.pages.main_page.actions.MainPageEventKEDO
import org.example.core.PageRoute


interface RouterKEDO {
    fun mainPageEventRouterKEDO(vararg events: MainPageEventKEDO): PageRoute<MainPageEventKEDO>
}
