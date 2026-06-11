plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.54.0"
    id ("application")
    id("org.sonarqube") version "7.3.0.8198"
    id("checkstyle")
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

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "GarryHuman_java-project-61")
        property("sonar.organization", "garryhuman")
    }
}

checkstyle {
    // Укажите актуальную версию (строка в двойных кавычках)
    toolVersion = "10.21.4"
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
}