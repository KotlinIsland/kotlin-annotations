# This is a WIP project to port jetbrains/java-annotations to Kotlin common
# Annotations for kotlin multiplatform 

A set of Kotlin annotations which can be used in multiplatform projects. They serve as an additional documentation and can be 
interpreted by IDEs and static analysis tools to improve code analysis.

[Change Log](CHANGELOG.md) | [Contributing](CONTRIBUTING.md) | [Code of Conduct](CODE_OF_CONDUCT.md)

## Using the annotations
The annotations are published on [Maven Central](https://repo1.maven.org/maven2/org/jetbrains/annotations/) and [JCenter](https://jcenter.bintray.com/org/jetbrains/annotations/). To add a dependency
using gradle write the following in the `build.gradle.kts` file:
```
dependencies {
    compileOnly("org.jetbrains:annotations:20.0.0")
}
```
