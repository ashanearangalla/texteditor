



api.registerTextChangeHandler { newText ->
    int caret = api.getCaretPosition()
    String beforeCaret = newText.substring(0, caret)

    String emojiText = ':-)';
    String emoji = '😊';

    if(beforeCaret.endsWith(emojiText)) {
        int start = caret - emojiText.length()
        api.setText(newText.substring(0, start) + emoji + newText.substring(caret))
        api.setCaretPosition(start + emoji.length())
        
    }
    
}