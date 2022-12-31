plugins {
    `kotlin-dsl`
    jacoco
    id("org.sonarqube") version ("3.5.0.2730")
}
repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
}