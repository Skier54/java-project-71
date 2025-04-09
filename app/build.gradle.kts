plugins {
    application
    id("com.github.ben-manes.versions") version "0.52.0"
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.12.0-M1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.6")
    implementation("org.apache.commons:commons-lang3:3.17.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    //annotationProcessor ("info.picocli:picocli-codegen:4.7.6")
    //compileOnly("org.projectlombok:lombok:1.18.24")
}

application {
    mainClass.set("hexlet.code.App")

}
tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}