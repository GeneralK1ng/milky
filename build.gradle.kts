plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.ntqqrev.saltify"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.ntqqrev.saltify:compose-idl:1.0-SNAPSHOT")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}