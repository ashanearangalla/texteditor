package edu.curtin.texteditor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;


public class KeymapLoader {
    

    public List<KeyBinding> loadKeymap(Path filePath) throws IOException, KeymapException {
        
        KeymapLexer lexer = new KeymapLexer(CharStreams.fromPath(filePath, StandardCharsets.UTF_8));
        KeymapParser parser = new KeymapParser(new CommonTokenStream(lexer));

        List<String> errors = new ArrayList<>();
        BaseErrorListener errorListener = new BaseErrorListener()
        {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg, RecognitionException e)
            {
                errors.add(String.format("line %d, column %d: %s", line, charPositionInLine, msg));
            }
        };
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        KeymapParser.KeymapContext keymapContext = parser.keymap();



        if(!errors.isEmpty())
        {
            throw new KeymapException(String.join("\n", errors));
        }

        List<KeyBinding> keymap = new ArrayList<>();

        for(KeymapParser.KeyBindingContext keyBindingContext : keymapContext.keyBinding())
        {
            KeyCombo keyCombo = extractKeyCombo(keyBindingContext.keyCombo());
            KeyAction keyAction = extractKeyAction(keyBindingContext);
            keymap.add(new KeyBinding(keyCombo, keyAction));
        }
        return keymap;


    }

    private KeyCombo extractKeyCombo(KeymapParser.KeyComboContext keyComboContext) throws KeymapException {
        boolean ctrl = false;
        boolean shift = false;
        boolean alt = false;

        for (Token modifierToken : keyComboContext.modifier) {
            String name = modifierToken.getText();
            switch (name) {
                case "ctrl":
                    ctrl = true;
                    break;
                case "shift":
                    shift = true;
                    break;
                case "alt":
                    alt = true;
                    break;
                default:
                    throw new KeymapException("Unknown modifier: " + name);
            }
        }
        String key = keyComboContext.key.getText();
        return new KeyCombo(ctrl, shift, alt, key);
        
    }

    private KeyAction extractKeyAction(KeymapParser.KeyBindingContext keyBindingContext)
    {
        String command = keyBindingContext.command.getText();
        String text = unquote(keyBindingContext.text);
        String position = (keyBindingContext.startOfLine() != null)
            ? "start of line"
            : "caret";

        return new KeyAction(command, text, position);
    }

    private static String unquote(Token t)
    {
        String s = t.getText();
        return s.substring(1, s.length() - 1);
    }

}
