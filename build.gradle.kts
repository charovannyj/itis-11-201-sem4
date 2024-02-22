import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass = "ru.kpfu.itis.nikolaev.Main"
}

group = "ru.kpfu.itis.nikolaev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-webmvc:${properties["springVersion"]}")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:${properties["tomcatVersion"]}")
    implementation("com.google.code.gson:gson:${properties["gsonVersion"]}")
    // https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20240205")
}


tasks.withType<ShadowJar> {
    mergeServiceFiles()
}
