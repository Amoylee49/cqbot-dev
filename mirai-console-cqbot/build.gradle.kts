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
//kotlin.sourceSets.all { languageSettings.
//useExperimentalAnnotation("kotlin.RequiresOptIn")
//}

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
    api("net.mamoe", "mirai-logging-slf4j-logback", "2.13.2")
// 在依赖 mirai-core 或 mirai-core-api 的前提下额外添加日志转接模块. 版本号相同
//    implementation(project(":data")) //注意这里
//    implementation("io.vertx:vertx-core:4.4.1")
//    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2") 打包插件
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

}

//注册task  https://juejin.cn/post/7149082070604578824
/*tasks.register<Delete>("cleannersssss") {
    delete(rootProject.buildDir)
}*/
//打jar包设置  https://blog.csdn.net/setlilei/article/details/123173339
tasks.jar.configure {

    //外部jar包
    from(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    //启动类设置
//    manifest.attributes["Main-Class"] = "com.example666666666666.Main"

//    from(configurations.runtimeClasspath.get().filter {
//        it.name.endsWith("jar")
//    }.map { zipTree(it) })
}

tasks.bootJar.configure {
    //排除外部jar
//        https://blog.csdn.net/yumo_fly/article/details/130272322
}