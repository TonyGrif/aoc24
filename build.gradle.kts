allprojects {
    repositories {
        mavenCentral()
    }
}

tasks.register<Copy>("collectJars") {
    dependsOn(subprojects.map { it.tasks.named("copyJarToRoot") })
}
