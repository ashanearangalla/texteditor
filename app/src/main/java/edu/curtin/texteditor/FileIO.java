package edu.curtin.texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;



/**
 * Performs the reading/parsing and writing of the CSV files containing timetable entries.
 */
public class FileIO
{
    /**
     * Loads a bus timetable from a given CSV file.
     */
    public TextString load(File file, String encoding) throws IOException, TextStringException
    {
        
        CharsetDecoder decoder = Charset.forName(encoding).newDecoder()
            .onMalformedInput(CodingErrorAction.REPORT)
            .onUnmappableCharacter(CodingErrorAction.REPORT);

        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(file), decoder)))
        {
            char[] buffer = new char[4096];
            int count;
            while((count = br.read(buffer)) != -1)
            {
                sb.append(buffer, 0, count);
            }
        }
        catch(IOException e)
        {
            throw new TextStringException("Error reading file", e);
        } 
        catch(Exception e)
        {
            throw new TextStringException("Error parsing file", e);
        }

        String text = sb.toString();

        return new TextString(text);
    }

    
    
    /**
     * Writes a bus timetable to a given CSV file.
     */
    public void save(File file, TextString entry, String encoding) throws IOException
    {
        try(PrintWriter pw = new PrintWriter(file, Charset.forName(encoding)))
        {

            pw.print(entry.getText());
            
        }
    }
}
