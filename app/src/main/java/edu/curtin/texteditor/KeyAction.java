package edu.curtin.texteditor;

public class KeyAction {
    private String command;
    private String text;
    private String position;

    public KeyAction(String command, String text, String position) {
        this.command = command;
        this.text = text;
        this.position = position;
    }

    public String getCommand()  { return command; }
    public String getText()     { return text; }
    public String getPosition() { return position; }

    public boolean isInsert()       { return command.equals("insert"); }
    public boolean isDelete()       { return command.equals("delete"); }
    public boolean isStartOfLine()  { return position.equals("start of line"); }
    public boolean isCaret()        { return position.equals("caret"); }
}
