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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.6")
    //annotationProcessor ("info.picocli:picocli-codegen:4.7.6")
    //compileOnly("org.projectlombok:lombok:1.18.24")
}

application {
    mainClass.set("hexlet.code.App")

}
tasks.test {
    useJUnitPlatform()
}
