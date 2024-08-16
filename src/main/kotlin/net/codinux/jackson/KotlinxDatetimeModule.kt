package net.codinux.jackson

import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.PackageVersion
import kotlinx.datetime.LocalDate

class KotlinxDatetimeModule : SimpleModule(KotlinxDatetimeModule::class.java.name, PackageVersion.VERSION) {

    override fun setupModule(context: SetupContext) {
        super.setupModule(context)

        addSerializer(LocalDate::class.java, LocalDateIso8601Serializer())
        addDeserializer(LocalDate::class.java, LocalDateIso8601Deserializer())
    }

}