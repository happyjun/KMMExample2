import org.gradle.api.Project
import org.gradle.kotlin.dsl.ScriptHandlerScope

// Kotlin
internal const val kotlinVersion = "1.6.21"

// Compose
internal const val jetbrainsComposeVersion = "1.2.0-alpha01-dev725"

// Android
internal const val androidGradlePluginVersion = "7.0.4"

/**
 * 工程依赖
 */
val Project.deps
    get() = ProjectDependencies

object ProjectDependencies {
}

/**
 * 工程编译脚本依赖
 */
val ScriptHandlerScope.deps
    get() = ProjectBuildScriptDependencies

object ProjectBuildScriptDependencies {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"
}