plugins {
    jacoco
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Application.namespace
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk

        testInstrumentationRunner = Application.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}