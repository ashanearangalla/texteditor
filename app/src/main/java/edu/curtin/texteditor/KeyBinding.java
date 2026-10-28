package edu.curtin.texteditor;

public class KeyBinding {
    private KeyCombo keyCombo;
    private KeyAction keyAction;

    public KeyBinding(KeyCombo keyCombo, KeyAction keyAction) {
        this.keyCombo = keyCombo;
        this.keyAction = keyAction;
    }

    public KeyCombo getKeyCombo()   { return keyCombo; }
    public KeyAction getKeyAction() { return keyAction; }

}
