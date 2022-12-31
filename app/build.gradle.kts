import Dependencies.Instrumentation
import Dependencies.Normal
import Dependencies.UnitTesting

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("jacoco")
//    id("plugins.jacoco")
    id("plugins.gitHooks")
}

android {
    namespace = Application.namespace
    compileSdk = Application.compileSdk

    defaultConfig {
        applicationId = Application.applicationId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName

        testInstrumentationRunner = Application.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    testCoverage {
        buildToolsVersion = ("30.0.3")
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    Normal.lists.forEach(::implementation)
    UnitTesting.list.forEach(::testImplementation)
    Instrumentation.list.forEach(::androidTestImplementation)
}