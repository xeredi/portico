grammar Path;

r
:
	path
	| FUNCTION
	(
		path
	)
;

FUNCTION
:
	'COALESCE'
;

path
:
	pathElement
	(
		PATH_SEPARATOR pathElement
	)*
;

PATH_SEPARATOR
:
	'.'
;

pathElement
:
	ELEMENT_PARENT LPAREN ID RPAREN
	| ELEMENT_DATA LPAREN ID RPAREN
	| ELEMENT_SERVICE
;

ELEMENT_PARENT
:
	'padre'
;

ELEMENT_DATA
:
	'dato'
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
