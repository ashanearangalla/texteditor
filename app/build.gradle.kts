// build.gradle.kts 
plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
    pmd
    antlr
}

repositories {
    mavenCentral()
}

// The 'java' plugin is applied implicitly by 'application'
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

javafx {
    version = "21"
    modules("javafx.controls", "javafx.graphics")
}

application {
    mainModule = "edu.curtin.texteditor"
    mainClass = "edu.curtin.texteditor.TextEditorApp"
}

dependencies {
    implementation(project(":api"))
    antlr("org.antlr:antlr4:4.13.2")
    implementation("org.apache.groovy:groovy:4.0.24")  
}

tasks.generateGrammarSource {
    packageName = "edu.curtin.texteditor"
}

pmd {
    toolVersion = "7.26.0"
    ruleSets = listOf("category/java/errorprone.xml")
}

tasks.named<JavaExec>("run") {
    workingDir = rootProject.projectDir
}