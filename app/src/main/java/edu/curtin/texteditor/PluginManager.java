package edu.curtin.texteditor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import edu.curtin.api.AppService;
import edu.curtin.api.PluginService;
import groovy.lang.Binding;
import groovy.lang.GroovyRuntimeException;
import groovy.lang.GroovyShell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PluginManager {

    private static final String MANIFEST_ATTRIBUTE = "TextEditor-Plugin-Main-Class";
    private final AppService appService;
    private final ObservableList<String> loaded = FXCollections.observableArrayList();


    public PluginManager(AppService appService) {
        this.appService = appService;
    }

    public ObservableList<String> getLoaded()
    {
        return loaded;
    }

    public void loadPlugin(File jarFile) throws PluginException
    {
        String pluginClassName;
        try(JarFile jf = new JarFile(jarFile))
        {
            Manifest manifest = jf.getManifest();
            if (manifest == null) {
                pluginClassName = null;
                
            } else {
                pluginClassName = manifest
                    .getMainAttributes()
                    .getValue("TextEditor-Plugin-Main-Class");
            }
            
        } catch(IOException e)
        {
            throw new PluginException(
                "Could not read " + jarFile.getName() + ": " + e.getMessage());
        }

        if(pluginClassName == null)
        {
            throw new PluginException(
                jarFile.getName() + " has no " + MANIFEST_ATTRIBUTE + " attribute in its manifest");
        }

        try
        {

            ClassLoader classLoader = new URLClassLoader(
                new URL[]{ jarFile.toURI().toURL() },
                PluginManager.class.getClassLoader());

            Class<?> cls = Class.forName(pluginClassName, true, classLoader);

            PluginService plugin = (PluginService) cls.getConstructor().newInstance();
            plugin.start(appService);

        }
        catch(MalformedURLException e)
        {
            throw new PluginException("Invalid file location: " + jarFile, e);
        }
        catch(InvocationTargetException e)
        {
            throw new PluginException("Plugin failed to start: " + e.getCause(), e);
        }
        catch(ReflectiveOperationException e)
        {
            throw new PluginException(
                "Could not load class " + pluginClassName + ": " + e, e);
        }
        catch(ClassCastException e)
        {
            throw new PluginException(
                pluginClassName + " does not implement PluginService", e);
        }

        loaded.add(pluginClassName + " (" + jarFile.getName() + ")");

    }




    public void runScript(File scriptFile) throws PluginException
    {
        String scriptText;
        try
        {
            scriptText = Files.readString(scriptFile.toPath(), StandardCharsets.UTF_8);
        }
        catch(IOException e)
        {
            throw new PluginException("Could not read " + scriptFile.getName() + ": " + e.getMessage(), e);
        }

        try
        {
            Binding binding = new Binding();
            binding.setVariable("api", appService);
            new GroovyShell(binding).evaluate(scriptText);
        }
        catch(GroovyRuntimeException e)
        {
            throw new PluginException("Error in script " + scriptFile.getName() + ": " + e.getMessage(), e);
        }
        loaded.add(scriptFile.getName());
    }
}
