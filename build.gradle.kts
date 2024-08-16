plugins {
    kotlin("jvm")
}


group = "net.codinux.jackson"
version = "1.0.0"


repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}

java {
    withSourcesJar()
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


ext["customArtifactId"] = "kotlinx-datetime-jackson-module"

ext["sourceCodeRepositoryBaseUrl"] = "github.com/codinux/KotlinxDateTimeJacksonModule"

ext["projectDescription"] = "Jackson serializers and deserializers for kotlinx-datetime"

apply(from = "./gradle/scripts/publish-codinux.gradle.kts")