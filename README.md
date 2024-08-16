# Jackson Module for kotlinx-datetime
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.codinux.jackson/kotlinx-datetime-jackson-module/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.codinux.jackson/kotlinx-datetime-jackson-module)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Jackson serializers and deserializers for all kotlinx-datetime types so that Jackson can serialize and deserialize kotlinx-datetime objects.

## Setup

### Gradle

```
implementation("net.codinux.jackson:kotlinx-datetime-jackson-module:1.0.0")
```

## Usage

```kotlin
    private val objectMapper = ObjectMapper().apply {
        registerModule(KotlinxDateTimeModule()) // that's all
    }
    

    // examples:
    
    private val AllKotlinxDateTimeTypesSerialized = """
            {
              "instant" : "2015-10-21T06:07:08.000000009Z",
              "dateTime" : "2015-10-21T06:07:08.000000009",
              "date" : "2015-10-21",
              "time" : "06:07:08.000000009",
              "dateTimePeriod" : "P1Y2M3DT4H5M6.000000007S",
              "datePeriod" : "P1Y2M3D"
            }
        """.trimIndent()
    
    fun deserializeKotlinxDateTimeTypes() {
        val deserialized = objectMapper.readValue<AllKotlinxDateTimeTypes>(AllKotlinxDateTimeTypesSerialized)
    }
    
    fun serializeKotlinxDateTimeTypes() {
        val toSerialize = AllKotlinxDateTimeTypes(
            Instant.parse("2015-10-21T06:07:08.000000009Z"),
            LocalDateTime(2015, 10, 21, 6, 7, 8, 9),
            LocalDate(2015, 10, 21),
            LocalTime(6, 7, 8, 9),
            DateTimePeriod(1, 2, 3, 4, 5, 6, 7),
            DatePeriod(1, 2, 3)
        )
    
        val json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(toSerialize)
    }
```


# License

    Copyright 2024 codinux GmbH & Co. KG

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
