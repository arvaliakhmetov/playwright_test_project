package pages.login_page

import org.example.configs.entities.User
import org.example.core.PageEvent

sealed interface LoginPageEvent: PageEvent {

    data class Login(val user: User): LoginPageEvent

}