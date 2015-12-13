grammar Condition;

import facturacion_common;

condition
:
	bool = BOOLEAN
	| lp = '(' cond1 = condition rp = ')'
	| unaryBool = 'NOT' cond1 = condition
	| cond1 = condition binaryBool =
	(
		'AND'
		| 'OR'
	) cond2 = condition
	| v1 = value relatOp = RELATIONAL_OP v2 = value
	| v1 = value likeOp =
	(
		'LIKE'
		| 'NOT LIKE'
	) v2 = value
	| v1 = value inOp =
	(
		'IN'
		| 'NOT IN'
	) cteList = constantList
	| v1 = value nullOp =
	(
		'IS NULL'
		| 'IS NOT NULL'
	)
	| v1 = value betweenOp =
	(
		'BETWEEN'
		| 'NOT BETWEEN'
	) v2 = value 'AND' v3 = value
;

constantList
:
	lp = '(' constant
	(
		',' constant
	)* rp = ')'
;
