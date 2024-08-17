plugins {
    kotlin("jvm")
}


group = "net.codinux.jackson"
version = "1.0.1-SNAPSHOT"


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

    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")


    testImplementation(kotlin("test"))

    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
}


tasks.test {
    useJUnitPlatform()
}

val versionFile = file("src/main/kotlin/net/codinux/jackson/PackageVersion.kt")

tasks.register("updateVersion") {
    group = "build"
    description = "Replaces the version in the source code file with the version from build.gradle.kts."

    inputs.file(versionFile)
    outputs.file(versionFile)

    doLast {
        val fileContent = versionFile.readText()
        val updatedContent = fileContent
            .replace(Regex("""(private const val VersionString = ")[^"]*""""), "$1$version\"")
            .replace(Regex("""(private const val GroupId = ")[^"]*""""), "$1${project.group}\"")
            .replace(Regex("""(private const val ArtifactId = ")[^"]*""""), "$1${ext["customArtifactId"]}\"")
        versionFile.writeText(updatedContent)

        val readme = file("README.md")
        val updatedReadmeContent = readme.readText()
            .replace(Regex("""(implementation\("net\.codinux\.jackson:kotlinx-datetime-jackson-module:)[^"]*""""), "$1$version\"")
        readme.writeText(updatedReadmeContent)
    }
}

tasks.named("compileKotlin") {
    dependsOn("updateVersion")
}


ext["customArtifactId"] = "kotlinx-datetime-jackson-module"

ext["sourceCodeRepositoryBaseUrl"] = "github.com/codinux/KotlinxDateTimeJacksonModule"

ext["projectDescription"] = "Jackson serializers and deserializers for kotlinx-datetime"

apply(from = "./gradle/scripts/publish-codinux.gradle.kts")