apply {
    from("$rootDir/base.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(Coroutines.coroutines)
    "implementation"("javax.inject:javax.inject:1")

}