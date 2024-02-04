package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState


abstract class PageRoute(
    events: Array<out PageEvent>,
    page: Page,
    state: TestState
){
    protected abstract fun handlePageEvent(pageEvent: PageEvent,page: Page,state: TestState)
    init {
        events.forEach { pageEvent ->
            handlePageEvent(pageEvent,page,state)
        }
    }
}