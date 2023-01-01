import Dependencies.Instrumentation
import Dependencies.Normal
import Dependencies.UnitTesting

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    jacoco
    id("plugins.gitHooks")
    id("org.sonarqube") version ("3.5.0.2730")
}


sonarqube {
    properties {
        property("sonar.projectKey", "PawanRoy1997_AmazeOTPField")
        property("sonar.organization", "pawanroy1997")
        property("sonar.host.url", "https://sonarcloud.io")
    }
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
        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
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

jacoco {
    this.toolVersion = "0.8.8"
}

dependencies {
    Normal.lists.forEach(::implementation)
    UnitTesting.list.forEach(::testImplementation)
    Instrumentation.list.forEach(::androidTestImplementation)
}