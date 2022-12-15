apply {
    from("$rootDir/base.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.auth_data))
    "implementation"(Coroutines.coroutines)
}