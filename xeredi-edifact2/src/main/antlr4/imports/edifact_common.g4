lexer grammar edifact_common;

ALPHANUMERIC
:
	(
		[A-Za-z0-9ñÑ]
		| ' '
		| '/'
		| ','
		| '.'
		| '-'
	)+
;

INTEGER
:
	(
		[0-9]
	)+
;

K_ADR
:
	'ADR'
;

K_AGR
:
	'AGR'
;

K_AJT
:
	'AJT'
;

K_ALC
:
	'ALC'
;

K_ALI
:
	'ALI'
;

K_APR
:
	'APR'
;

K_ARD
:
	'ARD'
;

K_ARR
:
	'ARR'
;

K_ASI
:
	'ASI'
;

K_ATT
:
	'ATT'
;

K_AUT
:
	'AUT'
;

K_BAS
:
	'BAS'
;

COLON
:
	':'
;

PLUS
:
	'+'
;

EOL
:
	'\'' ' '* '\n'*
;

WS
:
	[ \r\n\t]+ -> skip
;

