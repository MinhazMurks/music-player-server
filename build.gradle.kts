import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.liquibase.gradle") version "2.0.4"
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.7.0"
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.spring") version "1.7.0"
}

group = "minhaz"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-noarg:1.7.0")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.10")
    implementation("com.squareup.okhttp3:okhttp-ws:3.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.2")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.cdimascio:dotenv-kotlin:6.3.1")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.liquibase:liquibase-core:4.15.0")
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.vladmihalcea:hibernate-types-52:2.18.0")
    implementation("aws.sdk.kotlin:s3:0.17.5-beta")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

noArg {
    annotation("javax.persistence.Entity")
}

apply(plugin = "org.jetbrains.kotlin.plugin.noarg")

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
