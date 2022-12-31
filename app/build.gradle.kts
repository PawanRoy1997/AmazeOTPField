import Dependencies.Instrumentation
import Dependencies.Normal
import Dependencies.UnitTesting

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "PawanRoy1997.otpfield"
    compileSdk = 33

    defaultConfig {
        applicationId = "PawanRoy1997.otpfield"
        minSdk = 16
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    Normal.lists.forEach(::implementation)
    UnitTesting.list.forEach(::testImplementation)
    Instrumentation.list.forEach(::androidTestImplementation)
}