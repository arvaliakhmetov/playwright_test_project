package org.example.core

import com.microsoft.playwright.Page
import kotlinx.serialization.json.Json
import org.example.data.TestState

abstract class Action(
    private var data: PageEvent,
    private val testState: TestState,
    private val page: Page
) {
    protected val json =  Json {prettyPrint = true}
    private fun initialize() = runAction(data,testState,page)
    protected abstract fun runAction(data: PageEvent,testState: TestState, page: Page)

    init {
        initialize()
    }
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