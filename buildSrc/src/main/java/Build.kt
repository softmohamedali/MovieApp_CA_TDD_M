object Build {
    private const val androidBuildToolsVersion = "7.3.1"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    private const val hiltAndroidGradlePluginVersion = "2.38.1"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"

    const val googleServices="com.google.gms:google-services:4.3.13"

    const val kotlinSerilization="org.jetbrains.kotlin:kotlin-serialization:1.5.21"
}