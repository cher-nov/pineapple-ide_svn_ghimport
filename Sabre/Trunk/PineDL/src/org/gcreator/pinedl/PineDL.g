grammar PineDL;

tokens {
	PLUS = '+';
	MINUS = '-';
	MULT = '*';
	DIV = '/';
	MOD = '%';
	LPAREN = '(';
	RPAREN = ')';
	LARRAY = '[';
	RARRAY = ']';
	BBLOCK = '{';
	EBLOCK = '}';
	BTWAND = '&';
	BTWOR = '|';
	BTWXOR = '^';
	LOGAND = '&&';
	LOGOR = '||';
	STMTCUT = ';';
	DBLDOT = ':';
	BTWNOT = '~';
	LOGNOT = '!';
}

@header{
package org.gcreator.pinedl;
}

@lexer::header{
package org.gcreator.pinedl;
}

doc	:	pkgstmt
		impstmt*
		clsstmt;

pkgstmt	:	'package' context STMTCUT;
impstmt	:	'import' context STMTCUT;

clsstmt	:	'class' WORD ('extends' context)
		BBLOCK
			classcontent
		EBLOCK;
		
classcontent
	:	element*;
	
element	:	method|field|constructor;

field	:	PRIVACY 'static'? 'const' WORD WORD;

method	:	PRIVACY 'static'? WORD WORD LPAREN (argument (',' argument)*)? RPAREN
		BBLOCK
			code
		EBLOCK;

constructor
	:	PRIVACY THIS LPAREN (argument (',' argument)*)? RPAREN (DBLDOT (THIS|SUPER) LPAREN (WORD (',' WORD)*)? RPAREN )?
		BBLOCK
			code
		EBLOCK;
		
argument:	WORD WORD;

code	:	trycatch;

trycatch:	'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK;

context :	WORD ('.' WORD)*;

THIS	:	'this';

SUPER	:	'super';

PRIVACY	:	'public' | 'protected' | 'private';

NULL	:	'null';

BOOLEAN	:	'true' | 'false';

WORD	:	ALPHA (ALPHA|DIGIT)*;

STRING	:	'"' (~('"')|'\\\\'|'\\\''|'\\n') '"';

CHAR	:	'\'' (~('\'')|'\\\\'|'\\\''|'\\n') '\'';

FLOAT	:	DIGIT+ '.' DIGIT+ 'f';

DOUBLE	:	DIGIT+ '.' DIGIT+;

INTEGER	:	DIGIT+;

fragment ALPHA	:	'a'..'z'|'_';

fragment DIGIT	:	'0'..'9';

SLCOMMENT
	:	'//' ~('\r'|'\n') {$channel = HIDDEN; };

MLCOMMENT 
	:	'/*' ~('*/')* '*/' { $channel = HIDDEN; };

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
