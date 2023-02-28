plugins {
    kotlin("jvm") version "1.8.0"
}

group = "io.github.itsk1mlot.trafficlights"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}

task("testJar") {
    dependsOn(tasks.jar)
    val testServerDir = project.properties["testServerDir"]
    if(testServerDir != null) {
        tasks.jar.get().archiveFile.get().asFile.copyTo(File("${testServerDir}/plugins"))
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(18)
}