package org.ntqqrev.milky.generator.markdown

import org.ntqqrev.saltify.composeidl.Api
import org.ntqqrev.saltify.composeidl.Array
import org.ntqqrev.saltify.composeidl.Struct
import org.ntqqrev.saltify.composeidl.Type

class ApiMarkdownGenerator(val ctx: MarkdownGenerator) {
    fun generate(data: Api): String = StringBuilder()
        .appendLine("## `${data.name}` ${data.description}")
        .appendLine()
        .appendLine("### 参数")
        .appendLine()
        .appendLine(data.inputStruct?.let {
            if (it in ctx.documentedStructs)
                "见 [${it.name}](../struct/${it.name}.md)\n"
            else
                ctx.typeMarkdownGenerator.generateStruct(it)
        } ?: "此 API 无输入参数。")
        .appendLine("### 返回值")
        .appendLine()
        .append(data.outputType?.let {
            generateReturnTypeMarkdown(it)
        } ?: "此 API 无返回值。")
        .toString()

    private fun generateReturnTypeMarkdown(type: Type): String {
        if (type is Struct && type in ctx.documentedStructs) {
            return "见 [${type.name}](../struct/${type.name}.md)\n"
        }
        return when (type) {
            is Struct -> ctx.typeMarkdownGenerator.generateStruct(type)
            is Array -> "返回值为数组，元素类型如下：\n\n${generateReturnTypeMarkdown(type.elementType)}"
            else -> type.toString()
        }
    }
}