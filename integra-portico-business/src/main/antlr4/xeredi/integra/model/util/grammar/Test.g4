grammar Test;

condition
:
	booleanExpr
	(
		LOGIC_JUNCTOR booleanExpr
	)*
	| numericExpr COMPARATOR numericExpr
;

LOGIC_JUNCTOR
:
	'AND'
	| 'OR'
;

COMPARATOR
:
	'>'
	| '<'
	| '>='
	| '<='
	| '='
	| '<>'
;

booleanExpr
:
	'true'
	| 'false'
;

numericExpr
:
	NUMBER
;

NUMBER
:
	[0-9]+
	(
		. [0-9]+
	)?
;

WS
:
	[ \t\r\n]+ -> skip
;

/* a > b */