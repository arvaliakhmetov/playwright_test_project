package base

import com.microsoft.playwright.Page
import org.example.data.TestState
import org.example.pages.Router
import org.example.pages.card_page.CardPageEvent
import org.example.pages.card_page.CardPageRouteImpl
import org.example.pages.login_page.LoginPageRouteImpl
import org.example.pages.main_page.MainPageEvent
import org.example.pages.main_page.MainPageRouteImpl
import org.example.pages.util_page.UtilPageEvent
import org.example.pages.util_page.UtilPageRouteImpl
import org.slf4j.LoggerFactory
import pages.login_page.LoginPageEvent


class TestActionExecutor(
    private val page: Page,
    private var state: TestState,
) {
    val logger = LoggerFactory.getLogger(TestActionExecutor::class.java)


    private val router: Router = object : Router {
        override fun utilPageEventRouter(vararg events: UtilPageEvent) = UtilPageRouteImpl(events,page,state)
        override fun mainPageEventRouter(vararg events: MainPageEvent) = MainPageRouteImpl(events,page,state)
        override fun loginPageEventRouter(vararg events: LoginPageEvent) = LoginPageRouteImpl(events,page,state)
        override fun cardPageEventRouter(vararg events: CardPageEvent) = CardPageRouteImpl(events,page,state)
    }


    fun executeAction(pageActions: Router.() -> Unit)= pageActions.invoke(router)

    fun executeCustomAction(pageForActions: (Page) -> Unit) = pageForActions(page)

}

