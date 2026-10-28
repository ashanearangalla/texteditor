package edu.curtin.texteditor;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Example code for setting up a JavaFX GUI.
 */
public class MainUI 
{

    public static final int FONT_SIZE = 20;
    private TextArea textArea = new TextArea();
    private LoadSaveUI loadSaveUI;
    private Stage stage;
    private ResourceBundle bundle;
    private TextString textString;
    private Locale locale;
    private List<KeyBinding> keymap;
    private PluginManager pluginManager;
    
    public MainUI(Stage stage,TextString textString,List<KeyBinding> keymap, LoadSaveUI loadSaveUI, ResourceBundle bundle, Locale locale)
    {
        this.stage = stage;
        this.bundle = bundle;
        this.textString = textString;
        this.keymap = keymap;
        this.loadSaveUI = loadSaveUI;
        this.locale = locale;
    }


    public void display()
    {
        stage.setTitle(bundle.getString("app_title"));
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        // Create toolbar
        Button loadBtn = new Button(bundle.getString("load_btn"));
        Button saveBtn = new Button(bundle.getString("save_btn"));
        Button pluginsBtn = new Button(bundle.getString("plugins_btn"));
        ToolBar toolBar = new ToolBar(loadBtn, saveBtn, pluginsBtn);

        AppServiceImpl appService = new AppServiceImpl(textArea, toolBar, locale);
        pluginManager = new PluginManager(appService);

        // Subtle user experience tweaks
        toolBar.setFocusTraversable(false);
        toolBar.getItems().forEach(btn -> btn.setFocusTraversable(false));
        textArea.setStyle(String.format(
            "-fx-font-family: 'monospace'; -fx-font-size: %d;",
            FONT_SIZE)); // Set the font

        // Add the main parts of the UI to the window.
        BorderPane mainBox = new BorderPane();
        mainBox.setTop(toolBar);
        mainBox.setCenter(textArea);
        Scene scene = new Scene(mainBox);

        // Button event handlers.
        loadBtn.setOnAction(event -> loadSaveUI.load());
        saveBtn.setOnAction(event -> loadSaveUI.save());
        /* btn3.setOnAction(event -> toolBar.getItems().add(new Button("ButtonN"))); */
        pluginsBtn.setOnAction(event -> showPluginDialog());

        // TextArea event handlers & caret positioning.
        /* textArea.textProperty().addListener((object, oldValue, newValue) ->
        {
            System.out.println("caret position is " + textArea.getCaretPosition() +
                               "; text is\n---\n" + newValue + "\n---\n");
        }); */

        textArea.textProperty().addListener((object, oldValue, newValue) ->
        {
            appService.notifyTextChanged(newValue);
        });



        textArea.textProperty().bindBidirectional(textString.getTextProperty()); // Bind the text area to the TextString object
        textArea.selectRange(8, 16); // Select a range of text (and move the caret to the end)

        scene.setOnKeyPressed(keyEvent ->
        {
            KeyCode key = keyEvent.getCode();
            boolean ctrl = keyEvent.isControlDown();
            boolean shift = keyEvent.isShiftDown();
            boolean alt = keyEvent.isAltDown();

            if(key.isFunctionKey())
            {
                int keyNumber = Integer.parseInt(key.getName().substring(1));
                if(keyNumber <= 12)
                {
                    appService.notifyFunctionKey(keyNumber);
                    keyEvent.consume();
                }
            }

            for(KeyBinding binding : keymap)
            {
                KeyCombo combo = binding.getKeyCombo();
                KeyAction action = binding.getKeyAction();

                if(key.isLetterKey()
                && key.getChar().toLowerCase().equals(combo.getKey())
                && ctrl == combo.isCtrl()
                && shift == combo.isShift()
                && alt == combo.isAlt())
                {
                    String text = textArea.getText();
                    int caret = textArea.getCaretPosition();
                    int len = action.getText().length();

                    int position;

                    if(action.isStartOfLine())
                    {
                        position = text.lastIndexOf('\n', caret - 1) + 1;
                    }
                    else
                    {
                        position = caret;
                    }

                    if(action.isInsert())
                    {
                        textArea.insertText(position, action.getText());
                        textArea.positionCaret(caret + len);
                    }
                    else if(text.startsWith(action.getText(), position))
                    {
                        textArea.deleteText(position, position + len);

                        if(action.isStartOfLine())
                        {
                            textArea.positionCaret(Math.max(position, caret - len));
                        }
                        else
                        {
                            textArea.positionCaret(caret);
                        }
                    }
                    keyEvent.consume();
                }
            }
        }); 


        // Example global keypress handler.
        /* scene.setOnKeyPressed(keyEvent ->
        {
            // See the documentation for the KeyCode class to see all the availa ble keys.

            KeyCode key = keyEvent.getCode();
            boolean ctrl = keyEvent.isControlDown();
            boolean shift = keyEvent.isShiftDown();
            boolean alt = keyEvent.isAltDown();

            if(key == KeyCode.F1)
            {
                new Alert(Alert.AlertType.INFORMATION, "You pressed F1.", ButtonType.OK).showAndWait();
            }
            else if(ctrl && shift && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "Your pressed ctrl+shift+B.", ButtonType.OK).showAndWait();
            }
            else if(ctrl && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "You pressed ctrl+B.", ButtonType.OK).showAndWait();
            }
            else if(alt && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "You pressed alt+b.", ButtonType.OK).showAndWait();
            }
        }); */

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show(); 
    }

    private void showPluginDialog()
    {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle(bundle.getString("plugins_title"));
        dialog.setHeaderText(bundle.getString("plugins_header"));

        
        Button addJarBtn = new Button(bundle.getString("add_plugin_btn"));
        Button addScriptBtn = new Button(bundle.getString("add_script_btn"));
        ToolBar toolBar = new ToolBar(addJarBtn, addScriptBtn);

        addJarBtn.setOnAction(event ->
        {
            FileChooser chooser = new FileChooser();
            chooser.setTitle(bundle.getString("plugin_title"));
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JAR", "*.jar"));
            File file = chooser.showOpenDialog(stage);
            if(file != null)
            {
                try
                {
                    pluginManager.loadPlugin(file);
                }
                catch(PluginException e)
                {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE).showAndWait();
                }
            }
        });


        addScriptBtn.setOnAction(event ->
        {
            FileChooser chooser = new FileChooser();
            chooser.setTitle(bundle.getString("script_title"));
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Groovy", "*.groovy"));
            File file = chooser.showOpenDialog(stage);
            if(file != null)
            {
                try
                {
                    pluginManager.runScript(file);
                }
                catch(PluginException e)
                {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE).showAndWait();
                }
            }
        });

        ListView<String> listView = new ListView<>(pluginManager.getLoaded());

        BorderPane box = new BorderPane();
        box.setTop(toolBar);
        box.setCenter(new ScrollPane(listView));

        dialog.getDialogPane().setContent(box);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }

    /* private void showDialog1()
    {
        // TextInputDialog is a subclass of Dialog that just presents a single text field.

        var dialog = new TextInputDialog();
        dialog.setTitle("Text entry dialog box");
        dialog.setHeaderText("Enter text");

        // 'showAndWait()' opens the dialog and waits for the user to press the 'OK' or 'Cancel' button. It returns an Optional, which is a whole other discussion, but we can call 'orElse(null)' on that to get the actual string entered if the user pressed 'OK', or null if the user pressed 'Cancel'.

        var inputStr = dialog.showAndWait().orElse(null);
        if(inputStr != null)
        {
            // Alert is another specialised dialog just for displaying a quick message.
            new Alert(
                Alert.AlertType.INFORMATION,
                "You entered '" + inputStr + "'",
                ButtonType.OK).showAndWait();
        }
    }

    private void showDialog2()
    {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("List of things");
        dialog.setHeaderText("Here's a list of things");

        Button addBtn = new Button("Add...");
        Button removeBtn = new Button("Remove...");  // You don't need to remove anything; it just looks nice in the demo!
        ToolBar toolBar = new ToolBar(addBtn, removeBtn);

        addBtn.setOnAction(event ->
            new Alert(Alert.AlertType.INFORMATION, "You pressed 'Add'.", ButtonType.OK).showAndWait());
        removeBtn.setOnAction(event ->
            new Alert(Alert.AlertType.INFORMATION, "You pressed 'Remove'.", ButtonType.OK).showAndWait());

        // 'ObservableList' is a list that's also an Observer Pattern subject, while 'ListView'
        // shows the list contents on-screen, and registers itself as an observer, so it knows
        // when the list changes.
        ObservableList<String> listModel = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(listModel);
        for(int i = 0; i < 100; i++)
        {
            listModel.add("Item " + i);
        }

        BorderPane box = new BorderPane();
        box.setTop(toolBar);
        box.setCenter(new ScrollPane(listView));

        dialog.getDialogPane().setContent(box);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    } */
}