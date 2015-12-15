grammar facturacion_common;

value
:
	cte = constant
	| prop = property
	| lp = '(' v1 = value rp = ')'
	| v1 = value arithmeticOp = ARITHMETIC_OP v2 = value
	| fn = 'COALESCE' '(' v1 = value ',' v2 = value ')'
	| fn = 'CONCAT' '(' v1 = value ',' v2 = value ')'
	| fn = 'DECODE' '(' v1 = value decodeBranch* ',' v2 = value ')'
	| fn = 'acumuladoTeus' '(' v1 = value ',' v2 = value ',' v3 = value ')'
	| fn = 'valorServicio' '(' v1 = value ',' v2 = value ')'
;

decodeBranch
:
	',' v1 = value ',' v2 = value
;

constant
:
	NUMBER
	| STRING
	| BOOLEAN
	| NULL
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
	| son = ELEMENT_SON '(' arg = ID ')'
	| data = ELEMENT_DATA '(' arg = ID ')'
	| attribute = ELEMENT_ATTRIBUTE '(' arg = ID ')'
	| service = ELEMENT_SERVICE
;

ELEMENT_PARENT
:
	'padre'
;

ELEMENT_SON
:
	'hijo'
;

ELEMENT_ATTRIBUTE
:
	'atributo'
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
		| '%'
		| '&'
		| ' '
	)+ '\''
;

ID
:
	[A-Z0-9_]+
;

WS
:
	[ \t\r\n]+ -> skip
;
