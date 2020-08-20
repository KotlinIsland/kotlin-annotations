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

import javax.swing.SwingConstants
import java.awt.FlowLayout
import java.awt.Cursor
import java.awt.event.InputEvent
import java.awt.Adjustable
import javax.swing.ScrollPaneConstants
import java.util.Calendar
import javax.swing.BoxLayout
import javax.swing.ListSelectionModel
import javax.swing.tree.TreeSelectionModel
import java.awt.Font
import javax.swing.border.TitledBorder
import javax.swing.JTabbedPane
import java.lang.Exception

@Pattern(PrintFormatPattern.PRINT_FORMAT)
expect annotation class PrintFormat  // split up complex regex and workaround for IDEA-9173
internal object PrintFormatPattern {
    // %[argument_index$][flags][width][.precision]conversion
    // Expression is taken from java.util.Formatter.fsPattern
    @Language("RegExp")
    private val ARG_INDEX = "(?:\\d+\\$)?"

    @Language("RegExp")
    private val FLAGS = "(?:[-#+ 0,(<]*)?"

    @Language("RegExp")
    private val WIDTH = "(?:\\d+)?"

    @Language("RegExp")
    private val PRECISION = "(?:\\.\\d+)?"

    @Language("RegExp")
    private val CONVERSION = "(?:[tT])?(?:[a-zA-Z%])"

    @Language("RegExp")
    private val TEXT = "[^%]|%%"

    @Language("RegExp")
    val PRINT_FORMAT = "(?:" + TEXT + "|" +
            "(?:%" +
            ARG_INDEX +
            FLAGS +
            WIDTH +
            PRECISION +
            CONVERSION + ")" +
            ")*"
}