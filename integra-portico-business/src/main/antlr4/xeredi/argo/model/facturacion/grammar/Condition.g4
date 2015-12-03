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
;

constantList
:
	lp = '(' constant
	(
		',' constant
	)* rp = ')'
;
