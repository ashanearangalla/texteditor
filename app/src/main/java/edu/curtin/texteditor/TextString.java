package edu.curtin.texteditor;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TextString {

    private final SimpleStringProperty text;
    

    public TextString(String text) {
        this.text = new SimpleStringProperty(text);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String newText)
    {
        text.set(newText);
    }

    public StringProperty getTextProperty() {
        return text;
    }

    
}
