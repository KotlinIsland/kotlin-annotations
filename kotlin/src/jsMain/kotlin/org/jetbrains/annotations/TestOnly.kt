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
 * A member or type annotated with TestOnly claims that it should be used from testing code only.
 *
 *
 * Apart from documentation purposes this annotation is intended to be used by static analysis tools
 * to validate against element contract violations.
 *
 *
 * This annotation means that the annotated element exposes internal data and breaks encapsulation
 * of the containing class; the annotation won't prevent its use from production code, developers
 * even won't see warnings if their IDE doesn't support the annotation. It's better to provide
 * proper API which can be used in production as well as in tests.
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
actual annotation class TestOnly