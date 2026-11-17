# Extensible Text Editor

A JavaFX text editor built to be extended. You can add features at runtime by loading **Java plugins** (JAR files) or **Groovy scripts** through a shared plugin API. Keyboard shortcuts come from a user-editable `keymap.txt` that is parsed with an **ANTLR** grammar, and the UI is **localised** into English, Australian English and Sinhala.

## Features

- **Plugin system**: plugin JARs are loaded at runtime with `URLClassLoader` and reflection. The entry class is found through a custom manifest attribute.
- **Groovy scripting**: `.groovy` scripts run in an embedded `GroovyShell` with access to the same `api` object as plugins
- **Configurable key bindings**: shortcuts in `keymap.txt` are parsed by an ANTLR 4 grammar, and syntax errors are reported to the user
- **Internationalisation**: UI text comes from resource bundles (`en`, `en_AU`, `si_LK`), and plugins can use the locale for formatting and searching
- **Encoding-aware file I/O**: open and save files as UTF-8, UTF-16 or UTF-32
- **Plugin manager dialog** that lists every loaded plugin and script
- **Modular build**: Java Platform Module System, a multi-project Gradle build, and PMD static analysis

## Included plugins and scripts

| Name | Type | What it does |
|---|---|---|
| **FindPlugin** | JAR | Adds a *FindTerm* button and binds it to **F3**. Searches forward from the caret, ignoring case and Unicode differences (NFKC normalisation using the current locale), and selects the match. |
| **DatePlugin** | JAR | Adds a *DateTime* button that inserts the current date and time at the caret, formatted for the current locale |
| **ShoutPlugin** | JAR (example) | Pressing **F2** inserts `!` at the caret |
| **emoji.groovy** | Script | Replaces `:-)` with 😊 as you type |

## Project structure

```
texteditor/
├── api/                  # Shared plugin API (edu.curtin.api)
│   ├── AppService        # What plugins can do to the editor
│   ├── PluginService     # Interface every plugin implements
│   └── ButtonHandler, TextChangeHandler, FunctionKeyHandler
├── app/                  # The editor application (edu.curtin.texteditor)
│   ├── src/main/java/    # UI, plugin manager, file I/O, keymap loader
│   ├── src/main/antlr/   # Keymap.g4 grammar
│   └── src/main/resources/  # bundle*.properties (i18n)
├── findplugin/           # Find plugin
├── dateplugin/           # Date/time plugin
├── testplugin/           # Shout plugin (example)
├── scripts/emoji.groovy  # Example Groovy script
└── keymap.txt            # Key bindings loaded at startup
```

## Getting started

### Prerequisites

- JDK 21. The Gradle wrapper is included, and JavaFX is pulled in by the build.

### Run the editor

```bash
./gradlew run
```

Run it in a specific locale:

```bash
./gradlew run --args="--locale=si-LK"
./gradlew run --args="--locale=en-AU"
```

If no locale is given, the system default is used.

### Build the plugins

```bash
./gradlew :findplugin:jar :dateplugin:jar
```

The JARs are written to `findplugin/build/libs/` and `dateplugin/build/libs/`. To build the example ShoutPlugin, add `"testplugin"` to the `include(...)` line in `settings.gradle.kts`.

### Load plugins and scripts

1. Click **Plugins** in the toolbar.
2. Choose **Add plugin (jar)** and pick a plugin JAR, or **Add script** and pick a `.groovy` file.
3. Any buttons the plugin adds appear in the toolbar, and the plugin shows up in the loaded list.

### Static analysis

```bash
./gradlew check
```

## Key bindings

Bindings are read from `keymap.txt` in the project root when the editor starts:

```
ctrl+i       = insert "    " at start of line
ctrl+shift+i = delete "    " at start of line
ctrl+d       = insert "//" at start of line
ctrl+shift+d = delete "//" at start of line
alt+t        = insert "/*TODO*/" at caret
alt+f        = insert "/*FIXME*/" at caret
alt+s        = delete "/*TODO*/" at caret
alt+g        = delete "/*FIXME*/" at caret
```

Each line follows this format:

```
<modifier>+[<modifier>+...]<key> = insert|delete "<text>" at start of line | at caret
```

- Modifiers are `ctrl`, `alt` and `shift`, and keys are `a` to `z`
- Lines starting with `#` are comments
- The grammar is in `app/src/main/antlr/edu/curtin/texteditor/Keymap.g4`

## Writing a plugin

### 1. Implement `PluginService`

```java
package com.example;

import edu.curtin.api.AppService;
import edu.curtin.api.PluginService;

public class WordCountPlugin implements PluginService {
    public WordCountPlugin() {}   // public no-arg constructor is required

    @Override
    public void start(AppService api) {
        api.addButton("Words", () -> {
            String text = api.getText().strip();
            int count = text.isEmpty() ? 0 : text.split("\\s+").length;
            api.setText(api.getText() + "\n[" + count + " words]");
        });
    }
}
```

### 2. Declare the entry class in the JAR manifest

```kotlin
// build.gradle.kts
dependencies {
    compileOnly(project(":api"))
}

tasks.withType<Jar> {
    manifest {
        attributes("TextEditor-Plugin-Main-Class" to "com.example.WordCountPlugin")
    }
}
```

### `AppService` API

| Method | Purpose |
|---|---|
| `getText()` / `setText(String)` | Read or replace the document text |
| `getCaretPosition()` / `setCaretPosition(int)` | Get or move the caret |
| `getSelectionStart()`, `getSelectionEnd()`, `getSelectedText()`, `setSelection(int, int)` | Work with the selection |
| `addButton(String, ButtonHandler)` | Add a toolbar button |
| `registerTextChangeHandler(TextChangeHandler)` | Get a callback whenever the text changes |
| `registerFunctionKeyHandler(FunctionKeyHandler)` | Get a callback when F1–F12 is pressed |
| `getString(String prompt)` | Ask the user for text input |
| `getLocale()` | The editor's current locale |

### Groovy scripts

Scripts get the same API through a variable named `api`:

```groovy
api.addButton("Upper") {
    api.setText(api.getText().toUpperCase())
}
```

## Tech stack

Java 21 · JavaFX 21 · ANTLR 4.13 · Apache Groovy 4 · Gradle (Kotlin DSL) · JPMS · PMD

## Author

**Ashane Arangalla**: [github.com/ashanearangalla](https://github.com/ashanearangalla)
