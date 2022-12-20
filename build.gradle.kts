buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.googleServices)
//        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.42")

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath(Build.hiltAndroidGradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}



















//buildscript {
//    ext {
//        compose_ui_version = '1.1.1'
//    }
//}// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id 'com.android.application' version '7.3.0' apply false
//    id 'com.android.library' version '7.3.0' apply false
//    id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
//}
