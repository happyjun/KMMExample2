pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

rootProject.name = "KMMExample2"
include(":androidApp")
include(":shared")
include(":sharedUi")
include(":sharedUiiOS")
