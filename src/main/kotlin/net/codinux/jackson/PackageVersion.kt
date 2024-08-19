package net.codinux.jackson

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.core.Versioned
import com.fasterxml.jackson.core.util.VersionUtil

class PackageVersion : Versioned {

    companion object {
        // will be replaced by Gradle
        private const val VersionString = "1.0.2-SNAPSHOT"
        private const val GroupId = "net.codinux.jackson"
        private const val ArtifactId = "kotlinx-datetime-jackson-module"

        val Version = VersionUtil.parseVersion(VersionString, GroupId, ArtifactId)
    }


    override fun version(): Version = Version

}