grammar Path;

value
:
	function
	| path
	| scalar
;

function
:
	coalesce
;

coalesce
:
	'COALESCE' '(' value ',' value ')'
;

path
:
	pathElement
	(
		'.' pathElement
	)*
;

pathElement
:
	ELEMENT_PARENT '(' ID ')'
	| ELEMENT_DATA '(' ID ')'
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

ID
:
	[A-Z0-9_]+
;

scalar
:
	DOUBLE
	| INT
;

DOUBLE
:
	[0-9]+
	(
		. [0-9]+
	)?
;

INT
:
	[0-9]+
;

WS
:
	[ \t\r\n]+ -> skip
;
