package org.example.core

import com.microsoft.playwright.Page
import org.example.data.TestState

interface Action {
    fun run(page: Page,state: TestState)

    companion object XpathUtil{
        fun configuredPath(path: String, vararg params: String): String{
            var template = path
            params.forEachIndexed { index,param ->
                template = template.replace("%${index+1}%",param)
            }
            return template
        }
    }
}