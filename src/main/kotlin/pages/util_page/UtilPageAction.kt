package org.example.pages.util_page

import org.example.core.PageAction

sealed interface UtilPageAction: PageAction {

    data class Navigate(val path: String): UtilPageAction

}