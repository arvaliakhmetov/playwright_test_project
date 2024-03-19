package org.example.core


sealed interface PageEvent {
    interface KEDO : PageEvent

    interface SBER : PageEvent
    interface SHARED : PageEvent
}



