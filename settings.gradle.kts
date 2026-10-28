// settings.gradle.kts
rootProject.name = "texteditor"
include("api", "app", "findplugin", "dateplugin")


dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}