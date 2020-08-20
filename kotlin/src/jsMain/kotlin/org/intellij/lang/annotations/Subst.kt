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

/**
 * Specifies the replacement value for non-constant variables and method return values.
 * This may help static analyzers to properly parse the concatenation of several values
 * which is used in @[Language] or [Pattern] context.
 *
 *
 * Example:
 * <pre>
 * &#64;Subst("Tahoma")
 * final String font = new JLabel().getFont().getName();
 *
 * &#64;Language("HTML")
 * String message = "&lt;html&gt;&lt;span style='font: " + font + "; font-size:smaller'&gt;"
 * + ... + "&lt;/span&gt;&lt;/html&gt;";
</pre> *
 *
 *
 * Here the parser assumes that when `font` appears in the concatenation it's value is `"Tahoma"`,
 * so it can continue parsing the concatenation.
 *
 *
 * @see Language
 *
 * @see Pattern
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER)
actual annotation class Subst(val value: String)