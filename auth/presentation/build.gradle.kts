apply {
    from("$rootDir/baseCompose.gradle")
}

dependencies {
    "implementation"(project(Modules.auth_domain))
}