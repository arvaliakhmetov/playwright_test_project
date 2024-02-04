package org.example.pages.util_page

import org.example.core.PageEvent

sealed interface UtilPageEvent: PageEvent {

    data class Navigate(val path: String): UtilPageEvent

}