package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState


abstract class PageRoute<T>(
    events: Array<out T>,
    page: Page,
    state: TestState
){
    protected abstract fun handlePageEvent(pageEvent: T,page: Page,state: TestState): Action
    init {
        events.forEach { pageEvent ->
            handlePageEvent(pageEvent,page,state).run(page,state)
        }
    }
}