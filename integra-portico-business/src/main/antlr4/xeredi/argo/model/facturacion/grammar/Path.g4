grammar Path;

value
:
	nmb = NUMBER
	| str = STRING
	| pt = path
	| fn = 'COALESCE' '(' vl1 = value ',' vl2 = value ')'
	| fn = 'escalaNumeroPuertosBuque' '()'
	| fn = 'atraqueUdsGt' '()'
	| fn = 'escalaUdsGt' '()'
	| fn = 'escalaValorContador' '(' fnArg1 = STRING ')'
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
	NUMBER
	| STRING
;

STRING
:
	'\'' [A-Za-z0-9]+ '\''
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
