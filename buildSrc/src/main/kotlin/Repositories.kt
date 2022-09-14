import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven


fun RepositoryHandler.jetbrainsComposeDev() = maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")