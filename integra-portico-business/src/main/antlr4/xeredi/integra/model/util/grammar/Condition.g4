grammar Condition;

r
:
	booleanExpr
;

booleanExpr
:
	booleanExpr OPERATOR booleanExpr
	| '(' booleanExpr OPERATOR booleanExpr ')'
	| 'NOT' booleanExpr
	| 'COALESCE' '(' booleanExpr ', ' booleanExpr ')'
	| path
	| BOOLEAN_VALUE
	| INT_VALUE
	| DOUBLE_VALUE
	| DATE_VALUE
	| DATETIME_VALUE
	| TEXT_VALUE
;

OPERATOR
:
	'AND'
	| 'OR'
	| '<'
	| '<='
	| '=='
	| '<>'
	| '>'
	| '>='
;

INT_VALUE
:
	DIGIT+
;

DOUBLE_VALUE
:
	DIGIT+
	(
		. DIGIT+
	)?
;

DATE_VALUE
:
	'"' [2] DIGIT DIGIT DIGIT '-' [0-1] DIGIT '-' [0-3] DIGIT '"'
;

DATETIME_VALUE
:
	'"' [2] DIGIT DIGIT DIGIT '-' [0-1] DIGIT '-' [0-3] DIGIT [0-2] DIGIT ':'
	[0-5] DIGIT '"'
;

TEXT_VALUE
:
	'"' .*? '"'
;

DIGIT
:
	[0-9]
;

BOOLEAN_VALUE
:
	'true'
	| 'false'
;

path
:
	pathElement (PATH_SEPARATOR pathElement)*
;

PATH_SEPARATOR
:
	'.'
;

pathElement
:
	ELEMENT_PARENT LPAREN ID RPAREN
	| ELEMENT_DATA_SERVICE LPAREN ID RPAREN
	| ELEMENT_DATA_SUBSERVICE LPAREN ID RPAREN
	| ELEMENT_SERVICE
;

ELEMENT_PARENT
:
	'padre'
;

ELEMENT_DATA_SERVICE
:
	'datoSr'
;

ELEMENT_DATA_SUBSERVICE
:
	'datoSs'
;

ELEMENT_SERVICE
:
	'servicio'
;

LPAREN
:
	'('
;

RPAREN
:
	')'
;

ID
:
	[A-Z0-9_]+
;

WS
:
	[ \t\r\n]+ -> skip
;
