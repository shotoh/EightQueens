plugins {
    id("java")
}

group = "io.github.shotoh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "io.github.shotoh.EightQueens"
    }
}