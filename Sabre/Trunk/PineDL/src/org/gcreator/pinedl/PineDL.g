grammar PineDL;

options{
	backtrack = true;
}

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
	INC = '++';
	DEC = '--';
	EQ = '=';
	CEQ = '==';
	NEQ = '!=';
	BG = '>';
	BGE = '>=';
	LT = '<';
	LTE = '<=';
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

clsstmt	:	'class' WORD (DBLDOT context)
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

code	:	codel*;

codel	:	trycatch |
		assign |
		ifcase |
		whilecase |
		(type2value STMTCUT) |
		STMTCUT /*empty statement*/;

//type name [= expression]
//OR
//name = expression
//If it was [type] name [= expression], then simply name would be valid.
assign	:	((WORD WORD (EQ expression)?) | (WORD EQ expression)) STMTCUT;

//situation is NOT used because "try x=doIt(); catch(Exception e) doOther(); is not allowed.
//You MUST use the {}: try{x=doIt();}catch(Exception e){ doOther; } is allowed.
trycatch:	'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK;

ifcase	:	'if' LPAREN expression RPAREN situation
		elsif*
		elsecase?;

elsif	:	'elsif' LPAREN expression RPAREN situation;

elsecase:	'else' situation;

whilecase
	:	'white' LPAREN expression RPAREN situation;

situation
	:	codel | (BBLOCK code EBLOCK);

expression
	:	value | ('(' value ')') | ('(' operation ')' );

operation
	:	sgloperation | mltoperation ;

sgloperation
	:	(BTWNOT | LOGNOT) expression;

mltoperation
	:	expression
		(PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE)
		expression;

value	:	type1value | type2value | type3value;

//Increment/Decrement or pure variable
type1value
	:	(contextp | elemcontext) (INC|DEC)?;

//Function call
type2value
	:	((THIS|SUPER|WORD) '.')?
		(WORD) acelem* ('.' WORD acelem*)*;

acelem	:	((LARRAY expression RARRAY) | (LPAREN (WORD (',' WORD)* )? RPAREN) );

type3value
	:	NULL | BOOLEAN | STRING | CHAR | FLOAT | DOUBLE | INTEGER;

elemcontext
	:	(THIS|SUPER) ('.' WORD (LARRAY expression RARRAY)* )+;	

contextp:	WORD ('.' WORD (LARRAY expression RARRAY)* )+;

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

fragment ALPHA	:	'a'..'z'|'A'..'Z'|'_';

fragment DIGIT	:	'0'..'9';

SLCOMMENT
	:	'//' (~('\r'|'\n'))* {$channel = HIDDEN; };

MLCOMMENT 
	:	'/*' ( options {greedy=false;} : . )* '*/' { $channel = HIDDEN; };

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
