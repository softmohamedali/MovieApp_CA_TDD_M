apply {
    from("$rootDir/baseCompose.gradle")
}

dependencies {

    "implementation"(project(Modules.movies_domain))
    "implementation"(project(Modules.core))
    "implementation"(Coil.coilCompose)
}