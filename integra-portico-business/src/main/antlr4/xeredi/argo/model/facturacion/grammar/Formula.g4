grammar Formula;

formula
:
	aritmethicExpr
;

aritmethicExpr
:
	nmb = NUMBER
	| ae1 = aritmethicExpr opArit2 =
	(
		'+'
		| '-'
		| '*'
		| '/'
	) ae2 = aritmethicExpr
	| opArit1 = '-' ae1 = aritmethicExpr
	| pt = path
	| fn = 'COALESCE' '(' ae1 = aritmethicExpr ',' ae2 = aritmethicExpr ')'
	| fn = 'DECODE' '(' ae1 = aritmethicExpr
	(
		',' aritmethicExpr ',' aritmethicExpr
	)+ ',' ae2 = aritmethicExpr ')'
	| fn = 'escalaNumeroPuertosBuque' '()'
	| fn = 'atraqueUdsGt' '()'
	| fn = 'escalaUdsGt' '()'
	| fn = 'escalaValorContador' '(' fnArg1 = STRING ')'
	| lp = '(' ae1 = aritmethicExpr rp = ')'
;

NUMBER
:
	[0-9]+
	(
		. [0-9]+
	)?
;

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
