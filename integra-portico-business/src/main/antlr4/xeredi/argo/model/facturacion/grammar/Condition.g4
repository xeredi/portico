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
	| value1 = value relatOp = RELATIONAL_OP value2 = value
	| text1 = textValue likeOp = 'LIKE' text2 = textValue
	| value1 = value inOp =
	(
		'IN'
		| 'NOT IN'
	) cteList = constantList
	| value1 = value nullOp =
	(
		'IS NULL'
		| 'IS NOT NULL'
	)
;

constantList
:
	lp = '(' constant
	(
		',' constant
	)* rp = ')'
;
