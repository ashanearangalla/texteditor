package edu.curtin.shout;

import edu.curtin.api.AppService;
import edu.curtin.api.PluginService;

/**
 * Pressing F2 adds "!" at the caret.
 */
public class ShoutPlugin implements PluginService
{
    public ShoutPlugin() {}   // public no-arg constructor, required for reflection

    @Override
    public void start(AppService api)
    {
        api.registerFunctionKeyHandler(keyNumber ->
        {
            if(keyNumber == 2)
            {
                int caret = api.getCaretPosition();
                String text = api.getText();
                api.setText(text.substring(0, caret) + "!" + text.substring(caret));
                api.setCaretPosition(caret + 1);
            }
        });
    }
}