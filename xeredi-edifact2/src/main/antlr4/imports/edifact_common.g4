lexer grammar edifact_common;

EOL
:
	'\'' [ \t]*
	(
		(
			'\r'? '\n'
		)* EOF
		|
		(
			'\r'? '\n'
		)+
	)
;

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
		| '#'
		| '\'\''
		| '\n'
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

WS
:
	[ \t]+ -> skip
;

/*
EOL
:
	'\'' ' '* '\n'*
;

WS
:
	[ \r\n\t]+ -> skip
;
 */
