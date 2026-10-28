package edu.curtin.texteditor;


/**
 * Thrown in the event of a parsing error while reading a timetable Text file.
 */
public class TextStringException extends Exception
{
    public TextStringException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
