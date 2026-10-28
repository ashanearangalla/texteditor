package edu.curtin.texteditor;

public class KeyCombo {
    private boolean ctrl;
    private boolean shift;
    private boolean alt;
    private String key;

    public KeyCombo(boolean ctrl, boolean shift, boolean alt, String key) {
        this.ctrl = ctrl;
        this.shift = shift;
        this.alt = alt;
        this.key = key;
    }

    public boolean isCtrl()  { return ctrl; }
    public boolean isShift() { return shift; }
    public boolean isAlt()   { return alt; }
    public String getKey()   { return key; }
}
