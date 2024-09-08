buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath(libs.google.services)
    }
}

plugins {
    id(libs.plugins.androidApplication.toString()) apply false
}
