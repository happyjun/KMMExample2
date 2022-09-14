plugins {
    kotlin("multiplatform")
    id("com.android.library")
    jetbrainsCompose()
}

version = "1.0"

kotlin {
    android()
    iosX64("uikitX64")
    iosArm64("uikitArm64")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.ui)
//                implementation(compose.uiTooling)
//                implementation(compose.preview)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("io.coil-kt:coil-compose:2.1.0")
            }
        }
        val androidTest by getting

        val nativeMain by creating {
            dependsOn(commonMain)
        }

        val uikitMain by creating {
            dependsOn(nativeMain)
        }

        val uikitX64Main by getting {
            dependsOn(uikitMain)
        }
        val uikitArm64Main by getting {
            dependsOn(uikitMain)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}