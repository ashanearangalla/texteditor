package edu.curtin.texteditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import edu.curtin.api.AppService;
import edu.curtin.api.ButtonHandler;
import edu.curtin.api.FunctionKeyHandler;
import edu.curtin.api.TextChangeHandler;
import javafx.application.Platform;          // JavaFX, NOT java.awt
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;

public class AppServiceImpl implements AppService {

    private final TextArea textArea;
    private final ToolBar toolBar;
    private final List<TextChangeHandler> textChangeHandlers = new ArrayList<>();
    private final List<FunctionKeyHandler> functionKeyHandlers = new ArrayList<>();
    private final Locale locale;
    private boolean notifyingTextChange = false;

    public AppServiceImpl(TextArea textArea, ToolBar toolBar, Locale locale)
    {
        this.textArea = textArea;
        this.toolBar = toolBar;
        this.locale = locale;
    }

    @Override
    public Locale getLocale()
    {
        return locale;
    }

    @Override
    public String getString(String input){

        var dialog = new TextInputDialog();
        dialog.setHeaderText(input);
        return dialog.showAndWait().orElse(null);
    }

    @Override 
    public void addButton(String label, ButtonHandler handler) {
        Button button = new Button(label);
        button.setFocusTraversable(false);
        button.setOnAction(event -> handler.buttonPressed());
        toolBar.getItems().add(button);
    }

    @Override 
    public void registerTextChangeHandler(TextChangeHandler handler) {
        textChangeHandlers.add(handler);
    }

    @Override 
    public void registerFunctionKeyHandler(FunctionKeyHandler handler) {
        functionKeyHandlers.add(handler);
    }

    @Override
    public String getText()
    {
        return textArea.getText();
    }

    @Override
    public void setText(String text)
    {
        textArea.setText(text);
    }

    @Override
    public int getCaretPosition()
    {
        return textArea.getCaretPosition();
    }

    @Override
    public void setCaretPosition(int position)
    {
        int clamp = Math.max(0, Math.min(position, textArea.getLength()));
        textArea.positionCaret(clamp);
    }

    @Override
    public int getSelectionStart()
    {
        return textArea.getSelection().getStart();
    }

    @Override
    public int getSelectionEnd()
    {
        return textArea.getSelection().getEnd();
    }

    @Override
    public String getSelectedText()
    {
        return textArea.getSelectedText();
    }

    @Override
    public void setSelection(int start, int end)
    {
        int clampStart = Math.max(0, Math.min(start, textArea.getLength()));
        int clampEnd = Math.max(0, Math.min(end, textArea.getLength()));
        textArea.selectRange(clampStart, clampEnd);
    }


    public void notifyTextChanged(String newText)
    {
        if(notifyingTextChange) 
        {
            return;
        }
        notifyingTextChange = true;
        try
        {
            Platform.runLater(() ->
            {
                for(TextChangeHandler handler : new ArrayList<>(textChangeHandlers))
                {
                    handler.textChanged(textArea.getText());
                }
            });
        }
        finally
        {
            notifyingTextChange = false;
        }
    }


    public void notifyFunctionKey(int keyNumber)
    {
        for(FunctionKeyHandler handler : new ArrayList<>(functionKeyHandlers))
        {
            handler.functionKeyPressed(keyNumber);
        }
    }
}
