/*
 * Copyright 2000-2020 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intellij.lang.annotations

@Pattern(PrintFormatPattern.PRINT_FORMAT)
annotation class PrintFormat

// split up complex regex and workaround for IDEA-9173
object PrintFormatPattern {

    // %[argument_index$][flags][width][.precision]conversion

    // Expression is taken from java.util.Formatter.fsPattern

    @Language("RegExp")
    private const val ARG_INDEX = "(?:\\d+\\$)?"

    @Language("RegExp")
    private const val FLAGS = "(?:[-#+ 0,(<]*)?"

    @Language("RegExp")
    private const val WIDTH = "(?:\\d+)?"

    @Language("RegExp")
    private const val PRECISION = "(?:\\.\\d+)?"

    @Language("RegExp")
    private const val CONVERSION = "(?:[tT])?(?:[a-zA-Z%])"

    @Language("RegExp")
    const private val TEXT = "[^%]|%%"

    @Language("RegExp")
    const val PRINT_FORMAT = "(?:$TEXT|(?:%$ARG_INDEX$FLAGS$WIDTH$PRECISION$CONVERSION))*"
}