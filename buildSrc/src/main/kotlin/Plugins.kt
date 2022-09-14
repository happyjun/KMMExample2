import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.jetbrainsCompose() = id("org.jetbrains.compose") version jetbrainsComposeVersion