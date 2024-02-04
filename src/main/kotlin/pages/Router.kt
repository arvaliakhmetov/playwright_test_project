package org.example.pages

import jdk.nashorn.internal.objects.annotations.Constructor
import org.example.core.Action
import org.example.core.PageRoute
import org.example.pages.card_page.CardPageEvent
import org.example.pages.main_page.MainPageEvent
import org.example.pages.main_page.actions.OpenNewDocumentCardAction
import org.example.pages.util_page.UtilPageEvent
import org.example.pages.util_page.actions.NavigateAction
import pages.login_page.LoginPageEvent





interface Router {
    fun utilPageEventRouter(vararg events: UtilPageEvent) : PageRoute
    fun mainPageEventRouter(vararg events: MainPageEvent) : PageRoute
    fun loginPageEventRouter(vararg events: LoginPageEvent) : PageRoute
    fun cardPageEventRouter(vararg events: CardPageEvent) : PageRoute
}




//fun utilPageEventRouter(event: UtilPageEvent): Action {
//    return when (event) {
//        is UtilPageEvent.Navigate -> NavigateAction(event)
//    }
//}
//
//fun mainPageEventRouter(event: MainPageEvent): Action {
//    return when (event) {
//        is MainPageEvent.OpenNewDocument -> OpenNewDocumentCardAction(event)
//    }
//}
