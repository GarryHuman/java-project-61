import org.gradle.kotlin.dsl.repositories

plugins {
    id("application")
    id("com.github.ben-manes.versions") version "0.54.0"
    id("org.sonarqube") version "7.3.0.8198"
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
}

application {
    mainClass.set("hexlet.code.App")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "GarryHuman_java-project-61")
        property("sonar.organization", "garryhuman")
    }
}

checkstyle {
    toolVersion = "10.21.4"
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
}