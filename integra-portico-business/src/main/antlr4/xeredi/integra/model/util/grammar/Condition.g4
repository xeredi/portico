grammar Condition;

condition
:
	booleanExpr
;

booleanExpr
:
	be1 = booleanExpr opLogic2 =
	(
		'AND'
		| 'OR'
	) be2 = booleanExpr
	| opLogic1 = 'NOT' be1 = booleanExpr
	| bool =
	(
		'true'
		| 'false'
	)
	| se1 = scalarExpr opComp =
	(
		'>'
		| '<'
		| '>='
		| '<='
		| '='
		| '<>'
	) se2 = scalarExpr
//	| se1 = numericExpr in = 'IN' '(' scalarList ')'
	| lp = '(' be1 = booleanExpr rp = ')'
	| fn = 'escalaEsAvituallamiento' '()'
	| fn = 'escalaEsBuqueBaseEnPuerto' '()'
	| fn = 'escalaEsBuqueCertificado' '(' fnArg1 = STRING ')'
;

scalarExpr
:
	nmb = NUMBER
	| str = STRING
	| pt = path
	| fn = 'COALESCE' '(' ne1 = scalarExpr ',' ne2 = scalarExpr ')'
	| fn = 'escalaNumeroPuertosBuque' '()'
	| fn = 'atraqueUdsGt' '()'
	| fn = 'escalaUdsGt' '()'
	| fn = 'escalaValorContador' '(' fnArg1 = STRING ')'
;
/*
scalarList
:
	scalarList = scalar (',' scalar)*
;

scalar
:
	val = NUMBER
	| val = TEXT
	| ne1 = numericExpr
	;
*/

NUMBER
:
	[0-9]+
	(
		. [0-9]+
	)?
;

/*
TEXT
:
	[a-zA-Z0-9-+_]+
;
*/

STRING
:
	'\'' [A-Za-z0-9]+ '\''
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
	parent = ELEMENT_PARENT '(' arg = ID ')'
	| data = ELEMENT_DATA '(' arg = ID ')'
	| service = ELEMENT_SERVICE
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

WS
:
	[ \t\r\n]+ -> skip
;

/* a > b */