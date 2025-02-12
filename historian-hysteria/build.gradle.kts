plugins {
    application

    jacoco
    pmd

    id ("org.barfuin.gradle.jacocolog") version "3.1.0"
    id ("com.github.spotbugs") version "6.1.3"
    id ("com.diffplug.spotless") version "7.0.2"
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "adventofcode.one.CLI"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
    finalizedBy(tasks.jacocoTestReport)
}

jacoco {
    toolVersion = "0.8.12"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

pmd {
    toolVersion = "7.10.0"
    isConsoleOutput = true
}

tasks.pmdTest {
    enabled = false
}

tasks.withType<Pmd>().configureEach {
    ignoreFailures = true
}

spotless {
    java {
        importOrder()
        cleanthat()
        googleJavaFormat()
    }
}

tasks.check {
    dependsOn(tasks.spotlessCheck)
}

tasks.register("format") {
    dependsOn(tasks.spotlessApply)
}

spotbugs {
    ignoreFailures = true
}
