package edu.curtin.texteditor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;



public class TextEditorApp extends Application{


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        var localeString = getParameters().getNamed().get("locale");
        Locale locale;
        if(localeString != null)
        {
            locale = Locale.forLanguageTag(localeString);
        } 
        else {
            locale = Locale.getDefault();
        }
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);
        List<KeyBinding> keymap = null;
        try {
            keymap = new KeymapLoader().loadKeymap(Path.of("keymap.txt"));

        } catch (IOException | KeymapException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error loading keymap: " + e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            System.exit(1);
        }
        var textString = new TextString("");
        var fileIO = new FileIO();
        LoadSaveUI loadSaveUI = new LoadSaveUI(stage, textString, fileIO, bundle);
        new MainUI(stage, textString,keymap, loadSaveUI, bundle, locale).display();
    }

    
}
