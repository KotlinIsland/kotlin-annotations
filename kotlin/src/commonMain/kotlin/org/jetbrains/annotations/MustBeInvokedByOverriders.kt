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
 * The annotation should be applied to overridable non-abstract method
 * and indicates that all the overriders must invoke this method via
 * superclass method invocation expression. The static analysis tools
 * may report a warning if overrider fails to invoke this method.
 *
 * @since 20.0.0
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
expect annotation class MustBeInvokedByOverriders