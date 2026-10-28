package edu.curtin.date;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import edu.curtin.api.AppService;
import edu.curtin.api.PluginService;



public class DatePlugin implements PluginService{
    
    public DatePlugin() {

    }

    @Override 
    public void start(AppService api) {
        api.addButton ("DateTime", () -> {
            DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.LONG)
                .withLocale(api.getLocale());

            String dateTime = formatter.format(ZonedDateTime.now());

            int caret = api.getCaretPosition();
            String text = api.getText();
            api.setText(text.substring(0, caret) + dateTime + text.substring(caret));
            api.setCaretPosition(caret + dateTime.length());


        });
    }
}
