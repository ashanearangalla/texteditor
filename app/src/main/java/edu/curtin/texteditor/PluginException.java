package edu.curtin.texteditor;

public class PluginException extends Exception
{
    public PluginException(String msg)
    {
        super(msg);
    }

    public PluginException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}