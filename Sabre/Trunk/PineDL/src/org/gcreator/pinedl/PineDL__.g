lexer grammar PineDL;
@header {
package org.gcreator.pinedl;
}

PLUS : '+' ;
MINUS : '-' ;
MULT : '*' ;
DIV : '/' ;
MOD : '%' ;
LPAREN : '(' ;
RPAREN : ')' ;
LARRAY : '[' ;
RARRAY : ']' ;
BBLOCK : '{' ;
EBLOCK : '}' ;
BTWAND : '&' ;
BTWOR : '|' ;
BTWXOR : '^' ;
LOGAND : '&&' ;
LOGOR : '||' ;
STMTCUT : ';' ;
DBLDOT : ':' ;
BTWNOT : '~' ;
LOGNOT : '!' ;
T40 : 'package' ;
T41 : 'import' ;
T42 : 'class' ;
T43 : 'extends' ;
T44 : 'static' ;
T45 : 'const' ;
T46 : ',' ;
T47 : 'try' ;
T48 : 'catch' ;
T49 : '.' ;

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 72
THIS	:	'this';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 74
SUPER	:	'super';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 76
PRIVACY	:	'public' | 'protected' | 'private';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 78
NULL	:	'null';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 80
BOOLEAN	:	'true' | 'false';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 82
WORD	:	ALPHA (ALPHA|DIGIT)*;

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 84
STRING	:	'"' (~('"')|'\\\\'|'\\\''|'\\n') '"';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 86
CHAR	:	'\'' (~('\'')|'\\\\'|'\\\''|'\\n') '\'';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 88
FLOAT	:	DIGIT+ '.' DIGIT+ 'f';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 90
DOUBLE	:	DIGIT+ '.' DIGIT+;

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 92
INTEGER	:	DIGIT+;

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 94
fragment ALPHA	:	'a'..'z'|'_';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 96
fragment DIGIT	:	'0'..'9';

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 98
SLCOMMENT
	:	'//' ~('\r'|'\n') {$channel = HIDDEN; };

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 101
MLCOMMENT 
	:	'/*' ~('*/')* '*/' { $channel = HIDDEN; };

// $ANTLR src "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g" 104
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
