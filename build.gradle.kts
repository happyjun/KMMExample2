buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
        jetbrainsComposeDev()
    }
    dependencies {
        classpath(deps.kotlinGradlePlugin)
        classpath(deps.androidGradlePlugin)
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        jetbrainsComposeDev()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}