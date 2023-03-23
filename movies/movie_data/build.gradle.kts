apply {
    from("$rootDir/base.gradle")
}


dependencies {

    "implementation"(project(Modules.movies_domain))
    "implementation"(project(Modules.core))
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.moshiConverter)
    "implementation"(Retrofit.gsonConverter)
    "implementation"(Retrofit.scalersConverter)
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.okhttpsUrlConnection)

    "coreLibraryDesugaring" ("com.android.tools:desugar_jdk_libs:1.1.5")

    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
    "kapt"(Room.roomCompiler)


}