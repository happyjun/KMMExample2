plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    jetbrainsCompose()
}

version = "1.0"

kotlin {
    iosX64("uikitX64")
    iosArm64("uikitArm64")

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "11.0"
        framework {
            baseName = "TMM"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":sharedUi"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

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