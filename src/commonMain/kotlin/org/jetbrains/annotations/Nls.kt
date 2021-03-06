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

import kotlin.annotation.AnnotationTarget.*

/**
 * Specifies that an element of the program is an user-visible string which needs to be localized.
 * This annotation is intended to be used by localization tools for
 * detecting strings which should be reported as requiring localization.
 *
 * This annotation also could be used as a meta-annotation, to define derived annotations for convenience.
 * E.g. the following annotation could be defined to annotate the strings that represent dialog titles:
 *
 * ```kt
 * @Nls(capitalization = Capitalization.Title)
 * annotation class DialogTitle
 * ```
 *
 * Note that using the derived annotation as meta-annotation is not supported.
 * Meta-annotation works only one level deep.
 *
 * @see NonNls
 */
@Retention(AnnotationRetention.BINARY)
@Target(FUNCTION, FIELD, VALUE_PARAMETER, LOCAL_VARIABLE, TYPE, CLASS, FILE)
annotation class Nls(val capitalization: Capitalization = Capitalization.NotSpecified) {
    enum class Capitalization {
        NotSpecified,

        /**
         * e.g. This Is a Title
         */
        Title,

        /**
         * e.g. This is a sentence
         */
        Sentence,
    }
}
