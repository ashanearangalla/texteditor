package edu.curtin.find;

import java.text.Normalizer;
import java.util.Locale;

import edu.curtin.api.AppService;
import edu.curtin.api.PluginService;

public class FindPlugin implements PluginService
{


    public FindPlugin()
    {

    }

    @Override 
    public void start(AppService api)
    {
        api.addButton("FindTerm", () -> find(api));
        

        api.registerFunctionKeyHandler(keyNumber -> {
            if(keyNumber == 3) {
                find(api);
            }
        });
    }

    private void find(AppService api)
    {

        String searchTerm = api.getString("Search:");
        if(searchTerm == null || searchTerm.isEmpty()) {
            return;
        }
        
        Locale locale = api.getLocale();
        String text = api.getText();
        int caret = api.getCaretPosition();

        String afterCaret = normalise(text.substring(caret), locale);
        String term = normalise(searchTerm, locale);

        int found = afterCaret.indexOf(term);

        if(found != -1)
        {
            int start = caret + found;
            int end = start + term.length();
            api.setSelection(start, end);
        }

    }

    private String normalise(String s, Locale locale)
    {
        return Normalizer.normalize(s, Normalizer.Form.NFKC).toLowerCase(locale);
    }
    
}
