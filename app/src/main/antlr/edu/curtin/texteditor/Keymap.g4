grammar Keymap;

// parser rules
keymap : keyBinding* EOF ;
keyBinding : keyCombo '=' command=COMMAND text=STRING (startOfLine | atCaret) ;
keyCombo : (modifier+=MODIFIER '+')+ key=KEY ;
startOfLine : 'at' 'start' 'of' 'line' ;
atCaret     : 'at' 'caret' ;

// lexer rules
MODIFIER : 'ctrl'| 'alt' | 'shift' ;
COMMAND : 'insert' | 'delete' ;
KEY : [a-z] ;
STRING : '"' ~[""]* '"' ;
WHITESPACE : [ \t\n\r]+ -> skip ;
COMMENT    : '#' ~[\n]* -> skip ;
