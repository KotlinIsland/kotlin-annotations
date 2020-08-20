plugins {
    kotlin("multiplatform") version "1.4.10"
}

kotlin {
//    jvm { withJava() }
    js(IR) { nodejs(); browser() }
}