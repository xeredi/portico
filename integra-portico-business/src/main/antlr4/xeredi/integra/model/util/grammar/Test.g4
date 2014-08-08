grammar Test;

condition returns [String sql]
:
	a = booleanExpr
	{$sql=$a.sql;}

;

booleanExpr returns [String sql]
:
	be1 = booleanExpr op =
	(
		'AND'
		| 'OR'
	) be2 = booleanExpr
	{$sql=$be1.sql + ' ' + $op.text + ' ' + $be2.sql;}

	| op = 'NOT' be1 = booleanExpr
	{$sql=$op.text + ' ' + $be1.sql;}

	| bool =
	(
		'true'
		| 'false'
	)
	{$sql = $bool.text;}

	/*
 */
	| ne1 = numericExpr op =
	(
		'>'
		| '<'
		| '>='
		| '<='
		| '='
		| '<>'
	) ne2 = numericExpr
	{$sql=$ne1.sql + ' ' + $op.text + ' ' + $ne2.sql;}

	| lp = '(' be1 = booleanExpr rp = ')'
	{$sql=$lp.text + $be1.sql + $rp.text;}

	| 'escalaEsAvituallamiento()'
	{$sql="portico.escalaEsAvituallamiento(" + "${itemId}" + ", " + "${fref}" + ")";}

	| 'escalaEsBuqueBaseEnPuerto()'
	{$sql="portico.escalaEsBuqueBaseEnPuerto(" + "${itemId}" + ", " + "${fref}" + ")";}

	| 'escalaEsBuqueCertificado(' STRING ')'
	{$sql="portico.escalaEsBuqueCertificado(" + "${itemId}" + ", " + "${fref}" + ", " + $STRING.text + ")";}
;

numericExpr returns [String sql]
:
	NUMBER
	{$sql=$NUMBER.text;}
	/*
	| path
 */
	| 'COALESCE' '(' ne1 = numericExpr ',' ne2 = numericExpr ')'
	{$sql="COALESCE(" + $ne1.sql + ", " + $ne2.sql + ")";}

	| 'escalaNumeroPuertosBuque()'
	{$sql="portico.escalaNumeroPuertosBuque(" + "${itemId}" + ", " + "${fref}" + ")";}

	| 'escalaValorContador(' STRING ')'
	{$sql="portico.escalaValorContador(" + "${itemId}" + ", " + "${fref}" + ", " + $STRING.text + ")";}
;

NUMBER
:
	[0-9]+
	(
		. [0-9]+
	)?
;

STRING
:	'\'' [A-Za-z0-9]+ '\''
;

/*
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
*/
WS
:
	[ \t\r\n]+ -> skip
;

/* a > b */