
dependencies {
    implementation("org.jsoup:jsoup")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-test")
//    implementation(project(":data")) 可以引入
    implementation("io.reactivex.rxjava3:rxjava:3.1.6")
    implementation("io.vertx:vertx-core:4.4.1")
    implementation("org.mockito:mockito-core:2.23.4")
    implementation(project(":common-structure")) //可以引入
}
//kapt {
//
////        原文链接：https://blog.csdn.net/qq_35529969/article/details/124843352
//    keepJavacAnnotationProcessors = true
//}
