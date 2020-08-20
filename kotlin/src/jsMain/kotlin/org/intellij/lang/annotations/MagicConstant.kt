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

import org.jetbrains.annotations.NonNls
import kotlin.reflect.KClass

/**
 *
 * This annotation intended to help IntelliJ IDEA and other IDEs to detect and auto-complete int and String constants used as an enumeration.
 * For example, in the [java.awt.Label.Label] constructor the <tt>**alignment**</tt> parameter can be one of the following
 * int constants: [java.awt.Label.LEFT], [java.awt.Label.CENTER] or [java.awt.Label.RIGHT]
 *
 *
 * So, if <tt>@MagicConstant</tt> annotation applied to this constructor, the IDE will check the constructor usages for the allowed values.
 *
 * E.g.<br></br>
 * <pre>`new Label("text", 0); // 0 is not allowed
 * new Label("text", Label.LEFT); // OK
`</pre> *
 *
 *
 *
 * <tt>@MagicConstant</tt> can be applied to:
 *
 *  *  Field, local variable, parameter.
 *
 * <br></br>E.g. <br></br>
 * <pre>`@MagicConstant(intValues = {TOP, CENTER, BOTTOM})
 * int textPosition;
`</pre> *
 * The IDE will check expressions assigned to the variable for allowed values:
 * <pre>`textPosition = 0; // not allowed
 * textPosition = TOP; // OK
`</pre> *
 *
 *  *  Method
 *
 * <br></br>E.g.<br></br>
 * <pre>`@MagicConstant(flagsFromClass = java.lang.reflect.Modifier.class)
 * public native int getModifiers();
`</pre> *
 *
 * The IDE will analyse getModifiers() method calls and check if its return value is used with allowed values:<br></br>
 * <pre>`if (aClass.getModifiers() == 3) // not allowed
 * if (aClass.getModifiers() == Modifier.PUBLIC) // OK
`</pre> *
 *
 *  * Annotation class<br></br>
 * Annotation class annotated with <tt>@MagicConstant</tt> created alias you can use to annotate
 * everything as if it was annotated with <tt>@MagicConstant</tt> itself.
 *
 * <br></br>E.g.<br></br>
 * <pre>`@MagicConstant(flags = {Font.PLAIN, Font.BOLD, Font.ITALIC}) `</pre>
 * <pre>`@interface FontStyle {} `</pre>
 *
 * The IDE will check constructs annotated with @FontStyle for allowed values:<br></br>
 * <tt>@FontStyle int myStyle = 3; // not allowed<br></br></tt>
 * <tt>@FontStyle int myStyle = Font.BOLD | Font.ITALIC; // OK</tt><br></br>
 *
 *
 *
 * The <tt>@MagicConstant</tt> annotation has SOURCE retention, i.e. it is removed upon compilation and does not create any runtime overhead.
 */
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
actual annotation class MagicConstant(
        /**
         * @return int values (typically named constants) which are allowed here.
         * E.g.
         * <pre><tt>
         * `void setConfirmOpenNewProject(@MagicConstant(intValues = {OPEN_PROJECT_ASK, OPEN_PROJECT_NEW_WINDOW, OPEN_PROJECT_SAME_WINDOW})
         * int confirmOpenNewProject);
        `</tt></pre> *
         */
        val intValues: LongArray = [],
        /**
         * @return String values (typically named constants) which are allowed here.
         */
        val stringValues: Array<String> = [],
        /**
         * @return allowed int flags (i.e. values (typically named constants) which can be combined with bitwise OR operator (|).
         * The difference from the [.intValues] is that flags are allowed to be combined (via plus:+ or bitwise OR: |) whereas values aren't.
         * The literals "0" and "-1" are also allowed to denote absence and presense of all flags respectively.
         *
         * E.g.
         * <pre><tt>
         * `@MagicConstant(flags = {HierarchyEvent.PARENT_CHANGED,HierarchyEvent.DISPLAYABILITY_CHANGED,HierarchyEvent.SHOWING_CHANGED})
         * int hFlags;
         *
         * hFlags = 3; // not allowed; should be "magic" constant.
         * if (hFlags & (HierarchyEvent.PARENT_CHANGED | HierarchyEvent.SHOWING_CHANGED) != 0); // OK: combined several constants via bitwise OR
        `</tt></pre> *
         */
        val flags: LongArray = [],
        /**
         * @return allowed values which are defined in the specified class public static final constants.
         *
         * E.g.
         * <pre><tt>
         * `@MagicConstant(valuesFromClass = Cursor.class)
         * int cursorType;
         *
         * cursorType = 11; // not allowed; should be "magic" constant.
         * cursorType = Cursor.E_RESIZE_CURSOR; // OK: "magic" constant used.
        `</tt></pre> *
         */
        val valuesFromClass: KClass<*> = Unit::class,
        /**
         * @return allowed int flags which are defined in the specified class public static final constants.
         * The difference from the [.valuesFromClass] is that flags are allowed to be combined (via plus:+ or bitwise OR: |) whereas values aren't.
         * The literals "0" and "-1" are also allowed to denote absence and presense of all flags respectively.
         *
         * E.g.
         * <pre><tt>
         * `@MagicConstant(flagsFromClass = java.awt.InputEvent.class)
         * int eventMask;
         *
         * eventMask = 10; // not allowed; should be "magic" constant.
         * eventMask = InputEvent.CTRL_MASK | InputEvent.ALT_MASK; // OK: combined several constants via bitwise OR
        `</tt></pre> *
         */
        val flagsFromClass: KClass<*> = Unit::class)