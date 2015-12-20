grammar Expression;

expression
:
	condition
	| formula
;

condition
:
	lp = '(' c1 = condition rp = ')'
	| unaryOP = 'NOT' c1 = condition
	| c1 = condition binaryOP =
	(
		'AND'
		| 'OR'
	) c2 = condition
	| f1 = formula relationalOP =
	(
		'>'
		| '<'
		| '<='
		| '>='
		| '='
		| '<>'
		| 'LIKE'
		| 'NOT LIKE'
	)
	(
		allAnyOp =
		(
			'ALL'
			| 'ANY'
		) cteList = constantList
		| f2 = formula
	)
	| f1 = formula inOp =
	(
		'IN'
		| 'NOT IN'
	) cteList = constantList
	| f1 = formula nullOp =
	(
		'IS NULL'
		| 'IS NOT NULL'
	)
	| f1 = formula betweenOp =
	(
		'BETWEEN'
		| 'NOT BETWEEN'
	) f2 = formula 'AND' f3 = formula
;

formula
:
	cte = constant
	| prop = property
	| lp = '(' f1 = formula rp = ')'
	| unaryOP = '-' f1 = formula
	| f1 = formula binaryOP =
	(
		'+'
		| '-'
		| '*'
		| '/'
	) f2 = formula
	| fn = 'COALESCE' '(' f1 = formula ',' f2 = formula ')'
	| fn = 'ROUND' '(' f1 = formula ',' n1 = NUMBER_CONSTANT ')'
	| fn = 'CONCAT' '(' f1 = formula ',' f2 = formula ')'
	| fn = 'DECODE' '(' f1 = formula decodeBranch* ',' f2 = formula ')'
	| fn = 'acumuladoTeus' '(' f1 = formula ',' f2 = formula ',' f3 = formula ')'
	| fn = 'valorServicio' '(' f1 = formula ',' f2 = formula ')'
;

decodeBranch
:
	',' f1 = formula ',' f2 = formula
;

constantList
:
	lp = '(' constant
	(
		',' constant
	)* rp = ')'
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
	parent = 'padre' '(' arg = ID ')'
	| son = 'hijo' '(' arg = ID ')'
	| data = 'dato' '(' arg = ID ')'
	| attribute = 'atributo' '(' arg = ID ')'
	| service = 'servicio'
;

constant
:
	NUMBER_CONSTANT
	| STRING_CONSTANT
	| BOOLEAN_CONSTANT
	| NULL_CONSTANT
;

BOOLEAN_CONSTANT
:
	'true'
	| 'false'
	| 'TRUE'
	| 'FALSE'
;

NUMBER_CONSTANT
:
	[0-9]+
	(
		. [0-9]+
	)?
;

NULL_CONSTANT
:
	'null'
	| 'NULL'
;

STRING_CONSTANT
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
