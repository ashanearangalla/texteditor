package edu.curtin.api;

import java.util.Locale;

public interface AppService {
    

    Locale getLocale();

    String getString(String input);

    void addButton(String label, ButtonHandler handler);

    void registerTextChangeHandler(TextChangeHandler handler);
    void registerFunctionKeyHandler(FunctionKeyHandler handler);

    String getText();
    void setText(String text);

    int getCaretPosition();
    void setCaretPosition(int position);

    int getSelectionStart();
    int getSelectionEnd();
    String getSelectedText();
    void setSelection(int start, int end);

}
