plugins {
    kotlin("jvm")
}


group = "net.codinux.jackson"
version = "1.0.0-SNAPSHOT"


repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}


val kotlinxDatetimeVersion: String by project
val jacksonVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}