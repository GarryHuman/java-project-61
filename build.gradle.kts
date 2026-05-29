plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.54.0"
    id ("application")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "hexlet.code.App")
    }

    val runtimeClasspath = configurations.runtimeClasspath.get()

    from({
        runtimeClasspath.map { if (it.isDirectory) it else zipTree(it) }
    })

    // Дубликаты файлов могут возникнуть при распаковке зависимостей
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}