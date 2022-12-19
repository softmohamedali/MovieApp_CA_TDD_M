apply {
    from("$rootDir/baseCompose.gradle")
}

dependencies {
    "implementation"(project(Modules.auth_domain))
    "implementation"(project(Modules.core))
    "implementation"("javax.inject:javax.inject:1")
}