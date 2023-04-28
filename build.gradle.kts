plugins {
    id("java")
    id("org.springframework.boot") version "2.7.8"

}
apply(plugin = "io.spring.dependency-management")
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.postgresql:postgresql:42.5.3")
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE")
    implementation("org.springframework.security:spring-security-test")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation ("org.freemarker:freemarker:2.3.31")
    implementation ("org.springframework.boot:spring-boot-starter-freemarker")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}