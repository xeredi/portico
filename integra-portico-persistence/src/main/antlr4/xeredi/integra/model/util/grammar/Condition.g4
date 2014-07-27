grammar Condition;

r: booleanExpr;
booleanExpr: booleanItem ('OR' | 'AND') booleanItem;
booleanItem: booleanCond
;
booleanCond:
	booleanPart OPERATOR booleanPart
;
OPERATOR:
	'>' | '>=' | '=' | '<>' | '<' | '<='
;
booleanPart:
	INT
	| DOUBLE
	| path
;

INT : [0-9]+;
DOUBLE : [0-9]+(.[0-9]+)?;

path : token | token TOKEN_SEPARATOR path;
TOKEN_SEPARATOR : '.';
token :
          TOKEN_PARENT LPAREN ID RPAREN
      | TOKEN_DATA_SERVICE LPAREN ID RPAREN
      | TOKEN_DATA_SUBSERVICE LPAREN ID RPAREN
      | TOKEN_SERVICE
;

TOKEN_PARENT: 'padre';
TOKEN_DATA_SERVICE: 'datoSr';
TOKEN_DATA_SUBSERVICE: 'datoSs';
TOKEN_SERVICE: 'servicio';
LPAREN: '(';
RPAREN: ')';
ID : [A-Z0-9_]+ ;

WS : [ \t\r\n]+ -> skip ;