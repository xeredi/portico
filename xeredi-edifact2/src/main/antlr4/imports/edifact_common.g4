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
		| '?'
		| '%'
	)+
;

INTEGER
:
	(
		[0-9]
	)+
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

