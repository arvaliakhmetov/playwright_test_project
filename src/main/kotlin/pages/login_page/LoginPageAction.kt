package pages.login_page

import org.example.configs.entities.User
import org.example.core.PageAction

sealed interface LoginPageAction: PageAction {

    data class Login(val user: User): LoginPageAction

}