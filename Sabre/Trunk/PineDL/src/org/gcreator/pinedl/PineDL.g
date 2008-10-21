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
/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package org.gcreator.pinedl;
}

@lexer::header{
/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
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
	:	'/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; };

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };

