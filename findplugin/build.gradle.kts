plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(project(":api"))
}

tasks.withType<Jar> {
    manifest {
        attributes(
            "TextEditor-Plugin-Main-Class" to "edu.curtin.find.FindPlugin"
        )
    }
}