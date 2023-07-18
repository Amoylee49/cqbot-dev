import groovy.time.BaseDuration.From
import groovy.transform.stc.FromString
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include
import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    val kotlinVersion = "1.7.22"
//    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.15.0"
//    id("net.mamoe.mirai-logging-log4j") version "2.13.0-RC2"

// Kotlin添加对lombok注解支持   https://kotlinlang.org/docs/lombok.html
//    kotlin("plugin.lombok") version "1.7.21"
//    id("io.freefair.lombok") version "5.3.0"
}

//mirai {
//    coreVersion = "2.0-RC" // mirai-core version
//
//    publishing {
//        repo = "mirai"
//        packageName = "mirai-console-example-plugin"
//        override = true
//    }
//}

//kotlin.sourceSets.all { languageSettings.
//useExperimentalAnnotation("kotlin.RequiresOptIn")
//}

group = "org.cqbot.dev"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.aliyun.com/repository/public") // 阿里云国内代理仓库
}
dependencies {
//    api("net.mamoe", "mirai-core", "2.7.0")

//    implementation("org.projectlombok:lombok:1.18.24")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.14.1")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.14.1")
//    implementation("org.jsoup:jsoup:1.15.3")
    api("net.mamoe","mirai-logging-slf4j-logback","2.13.2")
// 在依赖 mirai-core 或 mirai-core-api 的前提下额外添加日志转接模块. 版本号相同
//    implementation(project(":data")) //注意这里
//    implementation("io.vertx:vertx-core:4.4.1")
//    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    apply(project(":common-structure")) //可以引入同级项目

//    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2") 打包插件
}
