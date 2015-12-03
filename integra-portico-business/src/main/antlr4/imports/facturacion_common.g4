grammar facturacion_common;

value
:
	numericValue
	| textValue
;

numericValue
:
	cte = NUMBER
	| prop = property
	| lp = '(' n1 = numericValue rp = ')'
	| n1 = numericValue arithmeticOp = ARITHMETIC_OP n2 = numericValue
	| fn = 'COALESCE' '(' n1 = numericValue ',' n2 = numericValue ')'
	| fn = 'DECODE' '(' n1 = numericValue decodeBranch+ ',' n2 = numericValue ')'
	| fn = 'escalaNumeroPuertosBuque' '()'
	| fn = 'atraqueUdsGt' '()'
	| fn = 'escalaUdsGt' '()'
	| fn = 'escalaValorContador' '(' cntName = STRING ')'
	/* 	| (minus = MINUS)? cte = NUMBER*/
;

decodeBranch
:
	',' n1 = numericValue ',' n2 = numericValue
;

textValue
:
	cte = STRING
	| prop = property
	| fn = 'COALESCE' '(' t1 = textValue ',' t2 = textValue ')'
	| fn = 'DECODE' '(' t1 = textValue
	(
		',' textValue ',' textValue
	)+ ',' t2 = textValue ')'
;

constant
:
	NUMBER
	| STRING
;

property
:
	propertyElement
	(
		'.' propertyElement
	)*
;

propertyElement
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

MINUS
:
	'-'
;

ARITHMETIC_OP
:
	'+'
	| '-'
	| '*'
	| '/'
;

RELATIONAL_OP
:
	'>'
	| '<'
	| '>='
	| '<='
	| '='
	| '<>'
;

NUMBER
:
	[0-9]+
	(
		. [0-9]+
	)?
	| NULL
;

NULL
:
	'null'
	| 'NULL'
;

BOOLEAN
:
	'true'
	| 'false'
;

STRING
:
	'\''
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '0' .. '9'
		| '+'
		| '-'
		| '_'
	)+ '\''
	| NULL
;

ID
:
	[A-Z0-9_]+
;

WS
:
	[ \t\r\n]+ -> skip
;
