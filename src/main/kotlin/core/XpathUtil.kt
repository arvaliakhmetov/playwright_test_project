package org.example.core


object XpathUtil {
    fun configuredPath(path: String, vararg params: String): String{
        var template = path
        params.forEachIndexed { index,param ->
            template = template.replace("%${index+1}%",param)
        }
        return template
    }
}