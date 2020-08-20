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
package org.jetbrains.annotations

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
 * An element annotated with [Nullable] claims `null` value is perfectly *valid*
 * to return (for methods), pass to (parameters) or hold in (local variables and fields).
 * Apart from documentation purposes this annotation is intended to be used by static analysis tools
 * to validate against probable runtime errors or element contract violations.
 * <br></br>
 * By convention, this annotation applied only when the value should *always* be checked against `null`
 * because the developer could do nothing to prevent null from happening.
 * Otherwise, too eager [Nullable] usage could lead to too many false positives from static analysis tools.
 * <br></br>
 * For example, [java.util.Map.get] should *not* be annotated [Nullable] because
 * someone may have put not-null value in the map by this key and is expecting to find this value there ever since.
 * <br></br>
 * On the other hand, the [java.lang.ref.Reference.get] should be annotated [Nullable] because
 * it returns `null` if object got collected which can happen at any time completely unexpectedly.
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.LOCAL_VARIABLE, TYPE_USE)
expect annotation class Nullable(val value: String = "")