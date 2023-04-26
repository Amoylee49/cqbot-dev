import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    val kotlinVersion = "1.7.22"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    // Kotlin添加对lombok注解支持   https://kotlinlang.org/docs/lombok.html
////    引入kapt插件
//    id("org.jetbrains.kotlin.kapt") version kotlinVersion
}

allprojects {
    group = "org.cqbot.dev"
    version = "1.0-SNAPSHOT"
    description = "org.cqbot.dev description"

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/nexus/content/repositories/google")
        maven("https://maven.aliyun.com/nexus/content/groups/public")
        maven("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
    }
}
java.sourceCompatibility = JavaVersion.VERSION_17


// 定义依赖的版本
var cloudVersion = "2021.0.0"
var cloudAlibabaVersion = "2.2.6.RELEASE"
var mybatisPlusVersion = "3.5.0"
var velocityVersion = "2.3"
// 适用于子模块配置
subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
//    apply(plugin = "org.jetbrains.kotlin.kapt")
    // 将plugins中的所有插件引入到subProject配置中（根据默认初始化的plugins逐一添加）
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
//
    dependencies {

//        kapt("org.projectlombok:lombok:1.18.24")
//        implementation("com.neenbedankt.gradle.plugins:android-apt:1.4")

//        implementation("org.springframework.boot:spring-boot-starter-web")
//        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        api("net.mamoe", "mirai-logging-slf4j-logback", "2.13.2")

    }
//    kapt {
////        原文链接：https://blog.csdn.net/qq_35529969/article/details/124843352
//        keepJavacAnnotationProcessors = true
//    }

    // 依赖管理，此功能是插件 io.spring.dependency-management 提供的，
    // 类似于 maven dependencyManagement 功能 在子类引入才引入包
    dependencyManagement {
        dependencies {
            dependency("com.baomidou:mybatis-plus-boot-starter:${mybatisPlusVersion}")
            dependency("org.jsoup:jsoup:1.15.3")
            dependency("io.reactivex.rxjava3:rxjava:3.1.6")
            dependency("io.vertx:vertx-core:4.4.1")
            dependency("org.mockito:mockito-core:2.23.4")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.register("prepareKotlinBuildScriptModel") {}
}

tasks.withType<Test> {
    useJUnitPlatform()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
//tasks.register("prepareKotlinBuildScriptModel"){}