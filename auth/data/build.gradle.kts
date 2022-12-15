apply {
    from("$rootDir/base.gradle")
}


dependencies {

    "implementation"(platform(Firebase.firebasePlatform))
    "implementation"(Firebase.firebaseAnalytics)
    "implementation"(Firebase.firebaseAuth)
    "implementation"(Firebase.firebaseFirestore)
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.auth_domain))
    "implementation"(Coroutines.coroutines)

}


